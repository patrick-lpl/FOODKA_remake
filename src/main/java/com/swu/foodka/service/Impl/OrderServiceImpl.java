package com.swu.foodka.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swu.foodka.dao.OrderDao;
import com.swu.foodka.entity.Order;
import com.swu.foodka.service.OrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
}
