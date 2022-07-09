package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxiaolin
 */
@Data
@TableName("bulletin")
public class Bulletin {
    @TableId("bulletin_id")

    private Integer bulletinId;

    private String info;

    private String createTime;
}
