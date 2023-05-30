package com.szh.springframework.context.event;

/**
 * 监听刷新
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public class ContextRefreshedEvent extends ApplicationContextEvent{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ContextRefreshedEvent(Object source) {
        super(source);
    }
}
