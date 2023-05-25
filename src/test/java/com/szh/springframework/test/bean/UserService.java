package com.szh.springframework.test.bean;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.DisposableBean;
import com.szh.springframework.beans.factory.InitializingBean;

import java.lang.reflect.InvocationTargetException;

/**
 * 实现 InitializingBean 和 DisposableBean 接口，重写销毁和初始化方法
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class UserService implements InitializingBean, DisposableBean {

    private String uId;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
    }

    @Override
    public void destroy() throws BeansException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws BeansException {
        System.out.println("执行：UserService.afterPropertiesSet");
    }


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

}
