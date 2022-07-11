package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxiaolin
 */
@Data
@TableName("message")
public class Message {
    @TableId("msg_id")

    /**
     * ID
     */
    private Integer msgId;
    /**
     * msg内容
     */
    private String msgContent;
    /**
     * msg的类型
     */
    private Integer msgType;

}
