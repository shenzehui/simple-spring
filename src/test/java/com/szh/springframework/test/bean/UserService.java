package com.szh.springframework.test.bean;

/**
 * 测试用例
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class UserService {

    private String uid;

    private UserDao userDao;


    public void queryUserInfo() {
        System.out.println("查询用户信息 " + userDao.queryUserName(uid));
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
