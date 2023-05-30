package com.szh.springframework.context.event;

import com.szh.springframework.context.ApplicationEvent;
import com.szh.springframework.context.ApplicationListener;

/**
 * 事件广播器
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public interface ApplicationEventMulticaster {

    /**
     * 添加监听
     * Add a listener to be notified of all events.
     *
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * 删除监听
     * Remove a listener from the notification list.
     *
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * 广播事件方法
     * Multicast the given application event to appropriate listeners.
     *
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
