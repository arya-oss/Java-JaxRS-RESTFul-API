package com.rahackya.restapp;

import org.junit.Test;

import com.rahackya.restapp.dao.UserDao;
import com.rahackya.restapp.model.User;

import org.junit.Assert;

import java.util.List;

public class UserDaoTest {

    @Test
    public void getTest() {
        UserDao userDao = UserDao.getInstance();
        User user = userDao.get(1);
        Assert.assertEquals("User rollno must be 137146", 137146, user.getRollno());
    }

    @Test
    public void getAllTest() {
        UserDao userDao = UserDao.getInstance();
        List<User> users = userDao.getAll();
        Assert.assertNotNull(users);
    }
}