package com.szh.springframework.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by szh on 2023-05-24
 *
 * @author szh
 */

public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "蔡新乐");
        hashMap.put("10002", "韩宝帅");
        hashMap.put("10003", "郭昌浩");
    }

    public String queryUserName(String uid) {
        return hashMap.get(uid);
    }
}
