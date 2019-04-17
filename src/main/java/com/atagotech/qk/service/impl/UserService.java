package com.atagotech.qk.service.impl;

import com.atagotech.qk.bean.data.User;
import com.atagotech.qk.mapper.UserMapper;
import com.atagotech.qk.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void insert(User user) {
        userMapper.insert(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void delete(int id) {
        userMapper.delete(id);
    }

    @Override
    public User find(int id) {
        return userMapper.find(id);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
