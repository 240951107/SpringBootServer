package com.atagotech.qk.mapper;

import com.atagotech.qk.bean.data.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    public void insert(User user);
    public void update(User user);
    public void delete(int id);
    public User find(int id);
    public User findByUsername(String username);
}