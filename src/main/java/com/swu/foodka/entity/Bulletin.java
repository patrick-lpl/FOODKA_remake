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

    /**
     * 公告ID
     */
    private Integer bulletinId;
    /**
     * 公告内容
     */
    private String info;
    /**
     * 公告发布时间
     */
    private String createTime;
}
