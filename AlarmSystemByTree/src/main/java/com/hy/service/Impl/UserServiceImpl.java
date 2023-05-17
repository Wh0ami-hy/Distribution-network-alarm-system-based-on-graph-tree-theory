package com.hy.service.Impl;

import com.hy.entity.User;
import com.hy.mapper.UserMapper;
import com.hy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public String login(String username) {
        return userMapper.login(username);
    }
}
