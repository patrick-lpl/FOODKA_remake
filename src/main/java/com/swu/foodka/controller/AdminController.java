package com.swu.foodka.controller;

import com.swu.foodka.controller.juit.AjaxResult;
import com.swu.foodka.dao.MessageDao;
import com.swu.foodka.entity.Admin;
import com.swu.foodka.entity.Message;
import com.swu.foodka.service.AdminService;
import com.swu.foodka.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author liuxiaolin
 */
@RestController // 添加到ioc容器
@RequestMapping("/admin") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class AdminController {
    @Autowired
    private AdminService adminService;

    @Autowired
    private MessageDao messageDao;

    /**
     * getAll
     * @return
     */
    @GetMapping("toList")
    public List<Admin> getAll(){
        return adminService.list();
    }

    /**
     * 更新用户表
     * @param admin
     * @return adminService.updateById(admin)
     */
    @PostMapping("/update")
    public boolean update(@RequestBody Admin admin){
        System.out.println("更新admin用户："+admin.getAdminName());
        return adminService.updateById(admin);
    }

    /**
     * 删除用户
     * @param id
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        System.out.println("删除admin用户："+id+"，"+adminService.getById(id).getAdminName());
        return adminService.removeById(id);
    }

    /**
     * getById
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Admin getById(@PathVariable int id){
        return adminService.getById(id);
    }

    /**
     * 登录（已接口规范化）
     * @param admin
     * @return
     * 前段vue用rel.data接收返回值判断
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody Admin admin){
        AjaxResult result = new AjaxResult();
        List<Admin> adminList = adminService.list();
        //request.getSession().setAttribute("user",admin); // 把登陆用户放入Session中
        for(Admin value: adminList) {
            if (value.getUsername().equals(admin.getUsername())) {
                if (value.getPassword().equals(admin.getPassword())) {
                    result.setFlag(true);
                    result.setMsg("登陆成功！欢迎：" + admin.getAdminName());
                    result.setDatas(admin);
                    return result;
                }
            }
        }
        result.setFlag(false);
        result.setMsg("用户名或密码不正确");
        return result;
    }

    /**
     * 保存用户
     * @param admin
     * @return
     */
    @PostMapping("/save")
    public boolean save(@RequestBody Admin admin) throws Exception{
        //admin.setPassword(EncryptUtil.shaEncode(admin.getPassword()));
        return adminService.save(admin);
    }

    /**
     * 注册
     * @param admin
     * @return if success
     */
    @PostMapping("/register")
    public boolean register(@RequestBody Admin admin) throws Exception{
        //admin.setPassword(EncryptUtil.shaEncode(admin.getPassword()));
        return adminService.save(admin);
    }

    public boolean saveMsg(){
        Message msg = new Message();
        msg.setMsgContent("有新用户注册！");
        msg.setMsgType(1);
        return messageDao.insert(msg)>0;
    }

    /**
     * 更新消息
     * @param id
     * @return
     */
    @PutMapping("putMsg")
    public  boolean updateMsg(@RequestParam("msg_id") Integer id){
        return messageDao.updataMsg(id)>0;
    }

    /**
     * 消息推送，get未读消息
     * @return
     */
    @GetMapping("/msg")
    public List<Message> getMsg(){
        return messageDao.selectType(1);
    }

//    //Test
//    @GetMapping // 访问方式
//    public String test(){
//        System.out.println("Testing.......");
//        return "Hallo";
//    }
}
