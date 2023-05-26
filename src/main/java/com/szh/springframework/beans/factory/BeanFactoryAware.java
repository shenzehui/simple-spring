package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;

/**
 * Interface to be implemented by beans that wish to be aware of their owning {@link BeanFactory}.
 * 实现此接口，即能感知到所属的 BeanFactory
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public interface BeanFactoryAware extends Aware {

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
