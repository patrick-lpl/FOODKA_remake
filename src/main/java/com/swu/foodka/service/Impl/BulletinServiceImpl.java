package com.swu.foodka.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swu.foodka.dao.BulletinDao;
import com.swu.foodka.entity.Bulletin;
import com.swu.foodka.service.BulletinService;
import org.springframework.stereotype.Service;

@Service
public class BulletinServiceImpl extends ServiceImpl<BulletinDao, Bulletin> implements BulletinService {
}
