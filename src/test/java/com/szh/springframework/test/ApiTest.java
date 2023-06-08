package com.szh.springframework.test;

import com.szh.springframework.context.support.ClassPathXmlApplicationContext;
import com.szh.springframework.test.bean.Husband;
import com.szh.springframework.test.bean.Wife;
import org.junit.Test;

/**
 * Created by szh on 2023-06-08
 *
 * @author szh
 */

public class ApiTest {

    @Test
    public void test_circular() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        Husband husband = applicationContext.getBean("husband", Husband.class);
        Wife wife = applicationContext.getBean("wife", Wife.class);
        System.out.println("老公的媳妇：" + husband.queryWife());
        System.out.println("媳妇的老公：" + wife.queryHusband());
    }
}
