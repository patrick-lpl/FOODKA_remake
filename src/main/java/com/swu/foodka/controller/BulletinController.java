package com.swu.foodka.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.swu.foodka.dao.BulletinDao;
import com.swu.foodka.entity.Bulletin;
import com.swu.foodka.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxiaolin
 */
@RestController // 添加到ioc容器
@RequestMapping("/bulletin") // 设置访问路径
@CrossOrigin // 解决跨域问题
public class BulletinController {

    @Autowired
    private BulletinService bulletinService;
    @Autowired
    private BulletinDao bulletinDao;

    /**
     * getAll
     * @return
     */
    @GetMapping
    public List<Bulletin> getAll(){
        return bulletinService.list();
    }

    /**
     * 根据id查询公告
     * @param id
     * @return Bulletin
     */
    @GetMapping("/selectId")
    public Bulletin selectId (@RequestParam Integer id){
        return bulletinService.getById(id);
    }

    /**
     * 新增公告
     * @param bulletin
     * @return
     */
    @PostMapping("/save")
    public boolean save(@RequestBody Bulletin bulletin){
        return bulletinService.save(bulletin);
    }

    /**
     * 根据id删除公告
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return bulletinService.removeById(id);
    }

    /**
     * getById
     * @param id
     * @return
     */
    @GetMapping("/get/{id}")
    public List<Bulletin> getById(@PathVariable Integer id){
        List<Bulletin> bulletinList=new ArrayList<>();
        bulletinList.add(bulletinService.getById(id));
        return bulletinList;
    }

    /**
     * 分页
     * @param num
     * @param size
     * @return
     */
    @GetMapping("/pages")
    public Page getAll(@RequestParam Integer num, @RequestParam Integer size){
        Page<Bulletin> bulletinPage=new Page<Bulletin>(num,size);
        List<Bulletin> bulletinList = bulletinDao.selectPages(num, size);
        int max = bulletinDao.selectCount();
        System.out.println(max/size);
        System.out.println(max*1.0/size);
        if(max/size==max*1.0/size){
            bulletinPage.setTotal(max/size);
        }else{            //分页出现不能整除情况
            bulletinPage.setTotal((max/size)+1);
        }
        System.out.println("total"+bulletinPage.getTotal());
        bulletinPage.setRecords(bulletinList);
        return bulletinPage;
    }

}
