package com.swu.foodka.entity;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("dish")
public class Dish {
    @TableId("dish_id")
    // 菜品编号
    private Integer dishId;
    // 菜品名称
    private String dishName;
    // 菜品单价
    private Double dishPrice;

}
