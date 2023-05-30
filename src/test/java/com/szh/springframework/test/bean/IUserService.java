package com.szh.springframework.test.bean;

/**
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public interface IUserService {
    String queryUserInfo();

    String register(String userName);
}
