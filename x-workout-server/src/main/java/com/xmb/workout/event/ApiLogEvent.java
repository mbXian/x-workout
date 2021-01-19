package com.xmb.workout.event;

import org.springframework.context.ApplicationEvent;

import java.util.Map;

/**
 * @author Ben
 * @date 2021-01-19
 * @desc
 */
public class ApiLogEvent extends ApplicationEvent {

    public ApiLogEvent(Map<String, Object> source) {
        super(source);
    }

}
