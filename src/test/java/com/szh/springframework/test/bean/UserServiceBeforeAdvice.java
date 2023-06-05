package com.szh.springframework.test.bean;

import com.szh.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author szh
 */
public class UserServiceBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }

}