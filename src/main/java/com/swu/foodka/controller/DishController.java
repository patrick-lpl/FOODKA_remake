package com.swu.foodka.controller;


import com.swu.foodka.entity.Dish;
import com.swu.foodka.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 添加到ioc容器
@RequestMapping("/dish") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class DishController {

    @Autowired
    private DishService dishService;

    /**
     * 获取全部菜品
     * @return
     */
    @GetMapping("toList")
    public List<Dish> getAll(){
        return dishService.list();
    }

    /**
     * 根据id获取货物
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Dish getById(@PathVariable int id) {
        return dishService.getById(id);
    }


}
