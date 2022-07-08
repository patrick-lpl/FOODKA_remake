package com.swu.foodka.controller;


import com.swu.foodka.entity.Bulletin;
import com.swu.foodka.entity.User;
import com.swu.foodka.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController // 添加到ioc容器
@RequestMapping("/bulletin") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class BulletinController {

    @Autowired
    private BulletinService bulletinService;

    @GetMapping
    public List<Bulletin> getAll(){
        return bulletinService.list();
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Bulletin bulletin){
        return bulletinService.save(bulletin);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return bulletinService.removeById(id);
    }

    @GetMapping("/get/{id}")
    public List<Bulletin> getById(@PathVariable Integer id){
        List<Bulletin> bulletinList=new ArrayList<>();
        bulletinList.add(bulletinService.getById(id));
        return bulletinList;
    }

}
