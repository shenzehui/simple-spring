package com.szh.springframework.context;

/**
 * 事件发布者的定义
 * ApplicationEventPublisher 是整个一个事件的发布接口，所有的事件都需要从这个接口发布出去。
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public interface ApplicationEventPublisher {

    /**
     * Notify all listeners registered with this application of an application
     * event. Events may be framework events (such as RequestHandledEvent)
     * or application-specific events.
     *
     * @param event the event to publish
     */
    void publishEvent(ApplicationEvent event);
}
