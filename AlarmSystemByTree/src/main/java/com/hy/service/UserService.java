package com.hy.service;

import com.hy.entity.User;

public interface UserService {
    public String login(String username);
    public Integer update(User user);
    public Integer register(User user);
    public String info(String username);
}
