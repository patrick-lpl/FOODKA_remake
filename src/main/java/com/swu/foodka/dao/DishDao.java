package com.swu.foodka.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swu.foodka.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DishDao extends BaseMapper<Dish> {

    /**
     * 模糊查询
     * @param name
     * @return
     */
    @Select("select * from goods where goods_name like #{name}")
    static List<Dish> selectPagesLike(@Param("name") String name) {
        return null;
    }

    /**
     * 查询有多少数据
     * @return
     */
    @Select("select count(*) from goods")
    int selectCount();
}
