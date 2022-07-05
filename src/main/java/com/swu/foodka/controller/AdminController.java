package com.swu.foodka.controller;

import com.swu.foodka.entity.Admin;
import com.swu.foodka.service.AdminService;
import com.swu.foodka.utils.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController // 添加到ioc容器
@RequestMapping("/admin") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class AdminController {
    @Autowired
    private AdminService adminService;

    // check
    @GetMapping("toList")
    public List<Admin> getAll(){
        return adminService.list();
    }

    /**
     * 更新用户表
     * @param admin
     * @return adminService.updateById(admin)
     */
    @PostMapping
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

    // check
    @GetMapping("/get/{id}")
    public Admin getById(@PathVariable int id){
        return adminService.getById(id);
    }

    /**
     * 登录
     * @param admin
     * @return 0=登录成功 1=用户名不存在 2=密码错误 -1=登陆失败（一般不会返回该值）
     * 前段vue用rel.data接收返回值判断
     */
    // check
    @PostMapping("/login")
    public Integer login(@RequestBody Admin admin) throws Exception{
        List<Admin> adminList = adminService.list();
        for(Admin value: adminList) {
            if (value.getUsername().equals(admin.getUsername())) {
                if (value.getPassword().equals(admin.getPassword())) {
                //if (value.getPassword().equals(EncryptUtil.shaEncode(admin.getPassword()))) {
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

//    //Test
//    @GetMapping // 访问方式
//    public String test(){
//        System.out.println("Testing.......");
//        return "Hallo";
//    }
}
