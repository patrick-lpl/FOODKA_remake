package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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

    private String usPassword;

}
