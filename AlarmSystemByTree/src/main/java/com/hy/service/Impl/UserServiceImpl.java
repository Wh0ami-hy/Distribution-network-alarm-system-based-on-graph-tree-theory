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
    @Override
    public Integer update(User user){return userMapper.update(user);}
    @Override
    public Integer register(User user) {
        return userMapper.register(user);
    }

    @Override
    public String info(String username) {
        return userMapper.info(username);
    }
}
