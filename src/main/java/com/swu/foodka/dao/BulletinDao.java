package com.swu.foodka.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swu.foodka.entity.Bulletin;
import com.swu.foodka.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BulletinDao extends BaseMapper<Bulletin> {
    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select("select * from bulletin limit #{pageNum},#{pageSize}")
    List<Bulletin> selectPages(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    /**
     * 模糊查询
     * @param usName
     * @return
     */
    @Select("select * from user where us_name like #{bulletinName}")
    List<Bulletin> selectPagesLike(@Param("bulletinName") String usName);

    /**
     * 查询总数
     * @return
     */
    @Select("select count(*) from bulletin")
    int selectCount();
}
