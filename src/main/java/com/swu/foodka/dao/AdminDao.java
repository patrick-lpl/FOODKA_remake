package com.swu.foodka.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swu.foodka.entity.Admin;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AdminDao extends BaseMapper<Admin> {
}
