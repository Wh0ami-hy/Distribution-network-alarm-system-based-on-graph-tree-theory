package com.hy.mapper;

import com.hy.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public String login(String username);
}
