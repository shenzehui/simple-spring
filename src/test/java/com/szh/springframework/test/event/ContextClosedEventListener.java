package com.szh.springframework.test.event;

import com.szh.springframework.context.ApplicationListener;
import com.szh.springframework.context.event.ContextClosedEvent;

/**
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }
}
