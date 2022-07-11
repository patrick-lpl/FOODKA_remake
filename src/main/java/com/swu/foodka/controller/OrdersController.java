package com.swu.foodka.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swu.foodka.config.ObjEvent;
import com.swu.foodka.dao.OrdersDao;
import com.swu.foodka.dao.UserDao;
import com.swu.foodka.entity.Orders;
import com.swu.foodka.entity.User;
import com.swu.foodka.service.OrdersService;
import com.swu.foodka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaolin
 */
@RestController // 添加到ioc容器
@RequestMapping("/orders") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class OrdersController {
    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * 获取全部订单
     * @return
     */
    @GetMapping("toList")
    public List<Orders> getAll(){
        return ordersService.list();
    }

    /**
     * 根据订单id获取订单信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public List<Orders> getById(@PathVariable int id) {
        List<Orders> ordersList=new ArrayList<>();
        ordersList.add(ordersService.getById(id));
        return ordersList;
    }

    /**
     * 根据用户id查询订单信息
     * @param id
     * @return
     */
    @GetMapping("/getUsOrder/{id}")
    public List<Orders> getByUsId(@PathVariable int id){
        List<Orders> ordersList = ordersDao.selectUsOrders(id);
        return ordersList;
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
        ObjEvent objEvent = new ObjEvent(orders.getOrderId(),orders,"new order!");
        boolean tf =ordersService.save(orders);
        webApplicationContext.publishEvent(objEvent);
        return tf;
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

    /**
     * 分页
     * @param num
     * @param size
     * @return
     */
    @GetMapping("/pages")
    public Page getAll(@RequestParam Integer num, @RequestParam Integer size){
        Page<Orders> ordersPage=new Page<Orders>(num,size);
        List<Orders> ordersList = ordersDao.selectPages(num, size);
        int max = ordersDao.selectCount();
        System.out.println(max*1.0/size);
        if(max/size==max*1.0/size){
            ordersPage.setTotal(max/size);
        }else{            //分页出现不能整除情况
            ordersPage.setTotal((max/size)+1);
        }
        System.out.println("total"+ordersPage.getTotal());
        ordersPage.setRecords(ordersList);
        return ordersPage;
    }
}
