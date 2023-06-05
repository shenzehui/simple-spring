package com.szh.springframework.test.bean;

import com.szh.springframework.beans.factory.annotation.Autowired;
import com.szh.springframework.beans.factory.annotation.Value;
import com.szh.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by szh on 2023-06-04
 *
 * @author szh
 */

public class UserService implements IUserService {

    private String token;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "小傅哥，100001，深圳，" + token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

