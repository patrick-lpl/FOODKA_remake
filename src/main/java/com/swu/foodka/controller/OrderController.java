package com.swu.foodka.controller;

import com.swu.foodka.entity.Order;
import com.swu.foodka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 添加到ioc容器
@RequestMapping("/order") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取全部订单
     * @return
     */
    @GetMapping("toList")
    public List<Order> getAll(){
        return orderService.list();
    }

    /**
     * 根据id获取订单信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Order getById(@PathVariable int id) {
        return orderService.getById(id);
    }

    /**
     * 删除订单
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        System.out.println("deleting order......");
        return orderService.removeById(id);
    }

    /**
     * 保存订单
     * @param order
     * @return
     */
    @PostMapping("/save")
    public boolean save(@RequestBody Order order){
        System.out.println("saveing order......");
        return orderService.save(order);
    }

    /**
     *更新菜品信息
     * @param order 商品对象
     * @return if success
     */
    @PutMapping
    public boolean update(@RequestBody Order order){
        System.out.println("updating order(ID):"+order.getOrderId());
        return orderService.updateById(order);
    }

}
