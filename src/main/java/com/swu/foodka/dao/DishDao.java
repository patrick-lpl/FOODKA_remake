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
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select("select * from dish limit #{pageNum},#{pageSize}")
    List<Dish> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 模糊查询
     * @param dishName
     * @return
     */
    @Select("select * from dish where dish_name like #{dishName}")
    List<Dish> selectPagesLike(@Param("dishName") String dishName);

    /**
     * 查询有多少数据
     * @return
     */
    @Select("select count(*) from dish")
    int selectCount();
}
