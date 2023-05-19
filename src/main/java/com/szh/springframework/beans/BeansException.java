package com.szh.springframework.beans;

import com.szh.springframework.beans.factory.config.BeanDefinition;

/**
 * Created by szh on 2023-05-19
 *
 * @author szh
 */

public class BeansException extends RuntimeException {

    public BeansException(String message) {
        super(message);
    }

    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }
}
