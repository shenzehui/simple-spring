package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;

/**
 * Created by szh on 2023-06-08
 *
 * @author szh
 */

public interface ObjectFactory <T>{

    T getObject() throws BeansException;
}
