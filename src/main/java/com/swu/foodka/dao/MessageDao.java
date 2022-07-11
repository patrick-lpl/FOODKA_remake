package com.swu.foodka.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swu.foodka.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuxiaolin
 */
@Mapper
@Component
public interface MessageDao extends BaseMapper<Message> {
    /**
     * 根据类型挑选msg
     * @param type
     * @return
     */
    @Select("select * from message where msg_type=#{type}")
    public List<Message> selectType(@Param("type") Integer type);

    /**
     * 将消息的类型更改为已读（type=0）
     * @param id
     * @return
     */
    @Update("update message set msg_type=0  where msg_id=#{id}")
    public  Integer updataMsg(@Param("id") Integer id);
}
