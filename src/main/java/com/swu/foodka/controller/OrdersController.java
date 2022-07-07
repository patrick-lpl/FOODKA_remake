package com.swu.foodka.controller;


import com.swu.foodka.entity.Orders;
import com.swu.foodka.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 添加到ioc容器
@RequestMapping("/orders") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 获取全部订单
     * @return
     */
    @GetMapping("toList")
    public List<Orders> getAll(){
        return ordersService.list();
    }

    /**
     * 根据id获取订单信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Orders getById(@PathVariable int id) {
        return ordersService.getById(id);
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        System.out.println("deleting order......");
        return ordersService.removeById(id);
    }

    /**
     * 保存订单
     * @param orders
     * @return
     */
    @PostMapping("/save")
    public boolean saveOrder(@RequestBody Orders orders){
        System.out.println("saving order......");
        return ordersService.save(orders);
    }

    /**
     *更新菜品信息
     * @param orders 商品对象
     * @return if success
     */
    @PutMapping("/update")
    public boolean updateOrder(@RequestBody Orders orders){
        System.out.println("updating order(ID):"+orders.getOrderId());
        return ordersService.updateById(orders);
    }
}
