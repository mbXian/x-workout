package com.xmb.workout.annotation;

import java.lang.annotation.*;

/**
 * @author Ben
 * @date 2021-01-18
 * @desc 操作日志注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

    /**
     * 日志描述
     * @return
     */
    String value() default "无日志描述";

}
