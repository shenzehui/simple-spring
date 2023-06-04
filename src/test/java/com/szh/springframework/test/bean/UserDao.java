package com.szh.springframework.test.bean;

import com.szh.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by szh on 2023-06-04
 *
 * @author szh
 */

@Component
public class UserDao {

    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "szh，湖州，德清");
        hashMap.put("10002", "lzh，上海，尖沙咀");
        hashMap.put("10003", "gch，天津，东丽区");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

}