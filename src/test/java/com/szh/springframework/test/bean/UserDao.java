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

    /**
     * 代替 static 更优雅的实现了自定义初始化和销毁方法
     */
    public void initDataMethod() {
        System.out.println("执行：init-method");
        hashMap.put("10001", "szh");
        hashMap.put("10002", "蔡新乐");
        hashMap.put("10003", "胡兵");
    }

    public void destroyDataMethod() {
        System.out.println("执行：destroy-method");
        hashMap.clear();
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }
}
