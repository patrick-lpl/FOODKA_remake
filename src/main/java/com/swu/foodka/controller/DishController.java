package com.swu.foodka.controller;


import com.swu.foodka.dao.DishDao;
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
     * 根据id获取菜品信息
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public Dish getById(@PathVariable int id) {
        return dishService.getById(id);
    }

    /**
     * 删除菜品
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        System.out.println("deleting dish......");
        return dishService.removeById(id);
    }

    /**
     * 保存菜品
     * @param dish
     * @return
     */
    @PostMapping("/save")
    public boolean save(@RequestBody Dish dish){
        System.out.println("saveing dish......");
        return dishService.save(dish);
    }

    /**
     *更新菜品信息
     * @param dish 商品对象
     * @return if success
     */
    @PutMapping
    public boolean update(@RequestBody Dish dish){
        System.out.println("updating dish"+dish.getDishName());
        return dishService.updateById(dish);
    }

    /**
     * 模糊查询
     */
    @GetMapping("/like")
    public List<Dish> getAllList(@RequestParam String name){
        System.out.println(name);
        return DishDao.selectPagesLike("%"+name+"%");
    }

}
