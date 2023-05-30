package com.szh.springframework.test.event;

import com.szh.springframework.context.ApplicationListener;
import com.szh.springframework.context.event.ContextRefreshedEvent;

/**
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }
}
