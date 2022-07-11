package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liuxiaolin
 */
@Data
@TableName("orders")
public class Orders {
    @TableId("order_id")
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 下单用户
     */
    private Integer usId;
    /**
     * 订单总价
     */
    private Double orderCost;
    /**
     * 下单时间
     */
    private String createTime;
}
