package com.szh.springframework.beans.factory;

/**
 * Interface to be implemented by beans that want to be aware of their bean name in a bean factory.
 * 实现此接口，既能感知到所属的 BeanName
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public interface BeanNameAware extends Aware {

    void setBeanName(String name);
}
