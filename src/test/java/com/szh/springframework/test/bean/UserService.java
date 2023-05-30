package com.szh.springframework.test.bean;

import java.util.Random;

/**
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public class UserService implements IUserService {
    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "szh，100001，杭州";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }
}
