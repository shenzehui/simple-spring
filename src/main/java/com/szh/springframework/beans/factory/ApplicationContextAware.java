package com.szh.springframework.beans.factory;

import com.szh.springframework.beans.BeansException;
import com.szh.springframework.context.ApplicationContext;

/**
 * Interface to be implemented by any object that wishes to be notifiedof the {@link ApplicationContext} that it runs in.
 * 实现此接口，既能感知到所属的 ApplicationContext
 * Created by szh on 2023-05-25
 *
 * @author szh
 */

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
