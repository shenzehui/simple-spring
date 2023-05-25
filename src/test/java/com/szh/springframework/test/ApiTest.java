package com.szh.springframework.test;

import com.szh.springframework.context.support.ClassPathXmlApplicationContext;
import com.szh.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * 测试
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class ApiTest {

    @Test
    public void test_xml() {
        // 1. 初始化 beanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取 Bean 对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUserInfo();
        System.out.println("测试结果:" + result);
    }

    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }

}
