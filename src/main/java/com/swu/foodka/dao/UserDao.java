package com.swu.foodka.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swu.foodka.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {
    //模糊查询
    @Select("select * from goods where goods_name like #{usName}")
    static List<User> selectPagesLike(@Param("usName") String usName) {
        return null;
    }

}
