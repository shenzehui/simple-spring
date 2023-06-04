package com.szh.springframework.test.bean;

import com.szh.springframework.stereotype.Component;

import java.util.Random;

/**
 * 给 UserService 类添加一个自定义注解 @Component("userService") 和一个属性信息 String token。
 * 这是为了分别测试包扫描和占位符属性
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

@Component("userService")
public class UserService implements IUserService {

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "szh，100001，深圳";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    @Override
    public String toString() {
        return "UserService#token = { " + token + " }";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}