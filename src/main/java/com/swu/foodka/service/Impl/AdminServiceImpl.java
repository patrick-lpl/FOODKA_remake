package com.swu.foodka.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.swu.foodka.dao.AdminDao;
import com.swu.foodka.entity.Admin;
import com.swu.foodka.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl extends ServiceImpl<AdminDao, Admin> implements AdminService {
}
