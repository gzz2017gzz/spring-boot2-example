package com.gzz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzz.dao.UserDao;
import com.gzz.entity.User;
import com.gzz.service.UserService;
/**
 * @author https://www.jianshu.com/u/3bd57d5f1074
 * @date 2019-12-24 10:50:00
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    @Override
    public List<User> getUserList() {
        return dao.findAll();
    }

    @Override
    public User findUserById(long id) {
        return dao.findById(id);
    }

    @Override
    public void save(User user) {
        dao.save(user);
    }

    @Override
    public void edit(User user) {
        dao.save(user);
    }

    @Override
    public void delete(long id) {
        dao.deleteById(id);
    }
}


