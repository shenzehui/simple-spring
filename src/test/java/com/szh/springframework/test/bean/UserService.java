package com.szh.springframework.test.bean;

/**
 * 测试用例
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    public void queryUserInfo() {
        System.out.println("查询用户信息 " + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }
}
