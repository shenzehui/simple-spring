package com.szh.springframework.test;

import com.szh.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import com.szh.springframework.context.support.ClassPathXmlApplicationContext;
import com.szh.springframework.test.bean.IUserService;
import com.szh.springframework.test.bean.UserService;
import org.junit.Test;

/**
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class ApiTest {

    /**
     * 单元测试（占位符）
     */
    @Test
    public void test_property() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-property.xml");
        IUserService userService = applicationContext.getBean("userService", UserService.class);
        System.out.println("测试结果：" + userService);
    }

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-scan.xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }


}
