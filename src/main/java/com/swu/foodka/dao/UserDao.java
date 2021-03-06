package com.swu.foodka.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swu.foodka.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@Mapper
public interface UserDao extends BaseMapper<User> {
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select("select * from user limit #{pageNum},#{pageSize}")
    List<User> selectPages(@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize);

    /**
     * 模糊查询
     * @param usName
     * @return
     */
    @Select("select * from user where us_name like #{usName}")
    List<User> selectPagesLike(@Param("usName") String usName);

    /**
     * 查询总数
     * @return
     */
    @Select("select count(*) from user")
    int selectCount();

}
