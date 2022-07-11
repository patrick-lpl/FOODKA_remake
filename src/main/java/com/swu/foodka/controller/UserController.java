package com.swu.foodka.controller;



import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swu.foodka.config.ObjEvent;
import com.swu.foodka.controller.juit.AjaxResult;
import com.swu.foodka.dao.UserDao;
import com.swu.foodka.entity.User;
import com.swu.foodka.service.UserService;
import com.swu.foodka.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaolin
 */
@RestController // 添加到ioc容器
@RequestMapping("/user") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private WebApplicationContext webapplicationcontext;

    /**
     * getAll返回用户list
     * @return
     */
    @GetMapping("toList")
    public List<User> getAll(){
        return userService.list();
    }

    @GetMapping("/selectId")
    public User selectId (@RequestParam Integer id){
        return userService.getById(id);
    }

    /**
     * 更新用户数据，包括密码加密
     * @param user
     * @return
     * @throws Exception
     */
    @PutMapping("/update")
    public boolean update(@RequestBody User user) throws Exception {
        System.out.println("更新用户："+user.getUsName());
        // 密码加密
        user.setUsPassword(EncryptUtil.shaEncode(user.getUsPassword()));
        return userService.updateById(user);
    }

    /**
     * 新增用户、密码加密（已规范化接口）
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping("/save")
    public AjaxResult save(@RequestBody User user) throws Exception{
        // 密码加密
        user.setUsPassword(EncryptUtil.shaEncode(user.getUsPassword()));
        AjaxResult result = new AjaxResult();
        if(userService.save(user)){
            System.out.println(user.getUsName()+"Save success!");
            result.setFlag(true);
            result.setDatas(user);
        }else {
            result.setFlag(false);
            result.setMsg("用户保存失败！");
        }
        return result;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        System.out.println("删除用户："+id+"，"+userService.getById(id).getUsName());
        return userService.removeById(id);
    }

    /**
     * 根据id搜索
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public List<User>  getById(@PathVariable int id){
        List<User> userList=new ArrayList<>();
        userList.add(userService.getById(id));
        return userList;
    }

    /**
     * 登录（已接口规范化）
     * @param user
     * @return result
     * 前段vue用rel.data接收返回值判断
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody User user, HttpServletRequest request) throws Exception {
        AjaxResult result = new AjaxResult();
        List<User> userList = userService.list();
        for(User value: userList) {
            if (value.getUsName().equals(user.getUsName())) {
                if (value.getUsPassword().equals(EncryptUtil.shaEncode(user.getUsPassword()))) {
                    // 把登陆用户放入Session中
                    request.getSession().setAttribute("user",user);
                    result.setFlag(true);
                    result.setMsg("登陆成功！欢迎：" + user.getUsName());
                    result.setDatas(user);

                    return result;
                }
            }
        }
        result.setFlag(false);
        result.setMsg("用户名或密码不正确");
        return result;
    }

    /**
     * 注册
     * @param user
     * @return if success
     */
    @PostMapping("/register")
    public AjaxResult register(@RequestBody User user) throws Exception {

        AjaxResult result = new AjaxResult();
        List<User> userList = userService.list();
        for(User value: userList){
            if(value.getUsName().equals(user.getUsName())){
                result.setFlag(false);
                result.setMsg("用户名已存在！");
                return result;
            }
        }
        ObjEvent objEvent=new ObjEvent(user.getUsName(),user,"new users");
        // 密码加密
        user.setUsPassword(EncryptUtil.shaEncode(user.getUsPassword()));
        userService.save(user);
        result.setFlag(true);
        result.setMsg("注册成功！欢迎："+user.getUsName());
        result.setDatas(user);
        webapplicationcontext.publishEvent(objEvent);
        return result;
    }



    /**
     * 模糊查询
     * @param usName
     * @return
     */
    @GetMapping("/like")
    public List<User> getAllList(@RequestParam String usName){
        System.out.println(usName);
        return userDao.selectPagesLike("%"+usName+"%");
    }

    /**
     * 分页
     * @param num
     * @param size
     * @return
     */
    @GetMapping("/pages")
    public Page getAll(@RequestParam Integer num, @RequestParam Integer size){
        Page<User> userPage=new Page<User>(num,size);
        List<User> userList = userDao.selectPages(num, size);
        int max = userDao.selectCount();
        System.out.println(max*1.0/size);
        if(max/size==max*1.0/size){
            userPage.setTotal(max/size);
        }else{            //分页出现不能整除情况
            userPage.setTotal((max/size)+1);
        }
        System.out.println("total"+userPage.getTotal());
        userPage.setRecords(userList);
        return userPage;
    }

    /**
     * 根据usName返回usId
     * @param usName
     * @return
     */
    @GetMapping("/getus")
    public Integer getUs(@RequestParam String usName){
        List<User> userList = userService.list();
        for(User value: userList){
            if(usName.equals(value.getUsName())) {
                return value.getUsId();
            }
        }
        return -1;
    }

    /**
     * 消息推送接口
     * @param user
     * @return
     */
    @PostMapping("/saveMsg")
    public String rest(@RequestBody User user){
        user.setUsQx(1);
        int num= userDao.insert(user);
        ObjEvent objEvent=new ObjEvent("users:",user,"新加用户了");
        webapplicationcontext.publishEvent(objEvent);
        return num>1?"成功":"失败";
    }





}
