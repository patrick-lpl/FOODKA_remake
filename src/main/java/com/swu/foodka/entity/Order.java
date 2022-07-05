package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("order")
public class Order {
    @TableId("order_id")
    private String orderId;

    private Integer usId;

    private Double total;

    private String creatTime;

}
