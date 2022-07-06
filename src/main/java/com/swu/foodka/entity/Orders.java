package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("orders")
public class Orders {
    @TableId("order_id")
    private Integer orderId;

    private Integer usId;

    private Double orderCost;

    private String createTime;
}
