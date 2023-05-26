package com.szh.springframework.test.bean;

/**
 * 实现 InitializingBean 和 DisposableBean 接口，重写销毁和初始化方法
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class UserService {
    private String uId;
    private String company;
    private String location;
    /**
     * 在 UserService 新修改了一个原有 UserDao 属性为 IUserDao，后面我们会给这个属性注入代理对象。
     */
    private IUserDao userDao;

    public String queryUserInfo() {
        return userDao.queryUserName(uId) + "," + company + "," + location;
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

    public IUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDao userDao) {
        this.userDao = userDao;
    }
}
