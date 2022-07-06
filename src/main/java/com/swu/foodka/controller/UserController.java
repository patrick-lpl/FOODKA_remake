package com.swu.foodka.controller;



import com.swu.foodka.dao.UserDao;
import com.swu.foodka.entity.User;
import com.swu.foodka.service.UserService;
import com.swu.foodka.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 添加到ioc容器
@RequestMapping("/user") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class UserController {

    @Autowired
    private UserService userService;

    // check
    @GetMapping("toList")
    public List<User> getAll(){
        return userService.list();
    }

    @PutMapping
    public boolean update(@RequestBody User user){
        System.out.println("更新用户："+user.getUsName());
        return userService.updateById(user);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody User user) throws Exception{
        //user.setUsPassword(EncryptUtil.shaEncode(user.getUsPassword()));
        return userService.save(user);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable String id){
        try{
            int int_id = Integer.parseInt(id);
        }catch (NumberFormatException e) {
            e.printStackTrace();
        }
        System.out.println("删除用户："+id+"，"+userService.getById(id).getUsName());
        return userService.removeById(id);
    }

    // check
    @GetMapping("/get/{id}")
    public User getById(@PathVariable int id){
        return userService.getById(id);
    }

    /**
     * 登录
     * @param user
     * @return 0=登录成功 1=用户名不存在 2=密码错误 -1=登陆失败（一般不会返回该值）
     * 前段vue用rel.data接收返回值判断
     */
    @PostMapping("/login")
    public Integer login(@RequestBody User user) throws Exception{
        List<User> userList = userService.list();
        for(User value: userList) {
            if (value.getUsName().equals(user.getUsName())) {
                if (value.getUsPassword().equals(user.getUsPassword())) {
                    //if (value.getUsPassword().equals(EncryptUtil.shaEncode(user.getUsPassword()))) {
                    System.out.println("登陆成功！");
                    return 0;
                }else
                    return 2;
            }else
                return 1;
        }
        return -1;
    }

    /**
     * 注册
     * @param user
     * @return if success
     */
    @PostMapping("/register")
    public boolean register(@RequestBody User user) throws Exception{
        //user.setUsPassword(EncryptUtil.shaEncode(user.getUsPassword()));
        return userService.save(user);
    }

    //模糊查询
    @GetMapping("/like")
    public List<User> getAllList(@RequestParam String usName){
        System.out.println(usName);
        return UserDao.selectPagesLike("%"+usName+"%");
    }
}
