package com.szh.springframework.context.event;

import com.szh.springframework.beans.factory.BeanFactory;
import com.szh.springframework.context.ApplicationEvent;
import com.szh.springframework.context.ApplicationListener;

/**
 * 事件广播器
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("uncheck")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listeners : getApplicationListeners(event)) {
            listeners.onApplicationEvent(event);
        }
    }
}
