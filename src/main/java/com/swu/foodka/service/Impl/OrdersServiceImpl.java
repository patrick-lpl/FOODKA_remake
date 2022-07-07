package com.swu.foodka.service.Impl;


import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swu.foodka.dao.OrdersDao;
import com.swu.foodka.entity.Orders;
import com.swu.foodka.service.OrdersService;
import org.springframework.stereotype.Service;

@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersDao, Orders> implements OrdersService {
}
