package com.szh.springframework.test.bean;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 代理对象:可以理解为 IUserDao 的实现类
 * Created by szh on 2023-05-26
 *
 * @author szh
 */

public class ProxyBeanFactory implements FactoryBean<IUserDao> {

    @Override
    public IUserDao getObject() throws BeansException {
        InvocationHandler handler = (proxy, method, args) -> {
            Map<String, String> hashMap = new HashMap<>();
            hashMap.put("10001", "szh");
            hashMap.put("10002", "cxl");
            hashMap.put("10003", "hb");
            return "你被代理了 " + method.getName() + ":" + hashMap.get(args[0].toString());
        };
        return (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{IUserDao.class}, handler);
    }

    @Override
    public Class<?> getObjectType() {
        return IUserDao.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
