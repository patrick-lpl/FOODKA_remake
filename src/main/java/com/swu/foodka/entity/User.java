package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxiaolin
 */
@Data
@TableName("user")
public class User {
    @TableId("us_id")
    private Integer usId;
    /**
     * 会员名称
     */
    private String usName;
    /**
     * 年龄
     */
    private Integer usAge;
    /**
     * 手机号码
     */
    private String usPhone;
    /**
     * 注册时间
     */
    private String createTime;

    /**
     * 用户密码
     */
    private String usPassword;
    /**
     * 用户头像
     */
    private String usPhoto;
    /**
     * 用户权限
     */
    private Integer usQx;
}
