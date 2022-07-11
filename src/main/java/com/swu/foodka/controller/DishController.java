package com.swu.foodka.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swu.foodka.dao.DishDao;
import com.swu.foodka.dao.UserDao;
import com.swu.foodka.entity.Dish;
import com.swu.foodka.entity.User;
import com.swu.foodka.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaolin
 */
@RestController // 添加到ioc容器
@RequestMapping("/dish") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class DishController {

    @Autowired
    private DishService dishService;

    @Autowired
    private DishDao dishDao;

    @GetMapping("/selectId")
    public Dish selectId (@RequestParam Integer id){
        return dishService.getById(id);
    }
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
    public List<Dish> getById(@PathVariable int id) {
        List<Dish>dishlist=new ArrayList<>();
            dishlist.add(dishService.getById(id));
        return dishlist;
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
        System.out.println("saveing dish......"+dish.getDishName());
        return dishService.save(dish);
    }

    /**
     *更新菜品信息
     * @param dish 商品对象
     * @return if success
     */
    @PutMapping("/update")
    public boolean update(@RequestBody Dish dish){
        System.out.println("updating dish"+dish.getDishName());
        return dishService.updateById(dish);
    }

    /**
     * 模糊查询
     */
    @GetMapping("/like")
    public List<Dish> getAllList(@RequestParam String dishName){
        System.out.println(dishName);
        return dishDao.selectPagesLike("%"+dishName+"%");
    }

    /**
     * 分页
     * @param num
     * @param size
     * @return
     */
    @GetMapping("/pages")
    public Page getAll(@RequestParam Integer num, @RequestParam Integer size){
        Page<Dish> dishPage=new Page<Dish>(num,size);
        List<Dish> dishList = dishDao.selectPages(num, size);
        int max = dishDao.selectCount();
        System.out.println(max*1.0/size);
        if(max/size==max*1.0/size){
            dishPage.setTotal(max/size);
        }else{            //分页出现不能整除情况
            dishPage.setTotal((max/size)+1);
        }
        System.out.println("total"+dishPage.getTotal());
        dishPage.setRecords(dishList);
        return dishPage;
    }

}
