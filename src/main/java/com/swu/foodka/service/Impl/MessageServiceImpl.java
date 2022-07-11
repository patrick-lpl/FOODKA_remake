package com.swu.foodka.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swu.foodka.dao.MessageDao;
import com.swu.foodka.entity.Message;
import com.swu.foodka.service.MessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageDao, Message> implements MessageService {
}
