package com.mcx.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcx.mapper.UserMapper;
import com.mcx.pojo.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
}
