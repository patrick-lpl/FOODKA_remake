package com.swu.foodka.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swu.foodka.entity.Orders;
import com.swu.foodka.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrdersDao extends BaseMapper<Orders> {
    //分页查询
    @Select("select * from order limit #{pageNum},#{pageSize}")
    List<Orders> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);
    //查询总数
    @Select("select count(*) from user")
    int selectCount();
}
