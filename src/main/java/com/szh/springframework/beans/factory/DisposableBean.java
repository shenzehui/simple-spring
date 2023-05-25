package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;

import java.lang.reflect.InvocationTargetException;

/**
 * 定义销毁方法的接口
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public interface DisposableBean {

    void destroy() throws BeansException, NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
