package com.atagotech.qk.service;

import com.atagotech.qk.bean.data.User;

public interface IUserService {
    public void insert(User user);
    public void update(User user);
    public void delete(int id);
    public User find(int id);
    public User findByUsername(String username);
}
