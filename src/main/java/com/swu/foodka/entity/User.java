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
    /**
     * 用户所在地
     */
    private String usArea;

    public Integer getUsId() {
        return usId;
    }

    public void setUsId(Integer usId) {
        this.usId = usId;
    }

    public String getUsName() {
        return usName;
    }

    public void setUsName(String usName) {
        this.usName = usName;
    }

    public Integer getUsAge() {
        return usAge;
    }

    public void setUsAge(Integer usAge) {
        this.usAge = usAge;
    }

    public String getUsPhone() {
        return usPhone;
    }

    public void setUsPhone(String usPhone) {
        this.usPhone = usPhone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUsPassword() {
        return usPassword;
    }

    public void setUsPassword(String usPassword) {
        this.usPassword = usPassword;
    }

    public String getUsPhoto() {
        return usPhoto;
    }

    public void setUsPhoto(String usPhoto) {
        this.usPhoto = usPhoto;
    }

    public Integer getUsQx() {
        return usQx;
    }

    public void setUsQx(Integer usQx) {
        this.usQx = usQx;
    }

    public String getUsArea() {
        return usArea;
    }

    public void setUsArea(String usArea) {
        this.usArea = usArea;
    }
}
