package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("admin")
@Data
public class Admin {
    @TableId("admin_id")
    //ID
    private Integer adminId;
    // 用户名
    private String username;
    // 密码
    private String password;
    // 姓名
    private String adminName;
    // 手机号
    private String adminPhone;
    // 邮箱
    private String adminEmail;
    // 创建时间
    private String createTime;
    // 修改时间
    private String updateTime;
    // 头像
    private String photo;
}
