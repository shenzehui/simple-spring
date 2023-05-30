package com.szh.springframework.context.event;

import com.szh.springframework.context.ApplicationContext;
import com.szh.springframework.context.ApplicationEvent;

/**
 * Created by szh on 2023-05-30
 *
 * @author szh
 */

public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return ((ApplicationContext) getSource());
    }
}
