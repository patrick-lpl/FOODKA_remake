package com.swu.foodka.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swu.foodka.entity.Bulletin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BulletinDao extends BaseMapper<Bulletin> {
}
