package com.swu.foodka.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swu.foodka.dao.DishDao;
import com.swu.foodka.entity.Dish;
import com.swu.foodka.service.DishService;
import org.springframework.stereotype.Service;

@Service
public class DishServiceImpl extends ServiceImpl<DishDao, Dish> implements DishService {
}
