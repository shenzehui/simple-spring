package com.szh.springframework.context;

import java.util.EventListener;

/**
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
