package com.xmb.workout.aspect;

import com.xmb.workout.annotation.ApiLog;
import com.xmb.workout.utils.network.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author Ben
 * @date 2021-01-18
 * @desc
 */
@Slf4j
@Component
@Aspect
public class ApiLogAspect {

    @Around(value = "@annotation(apiLog)")
    public void around(ProceedingJoinPoint point, ApiLog apiLog) throws Throwable {
        //获取类名
        String className = point.getTarget().getClass().getName();
        //获取方法
        String methodName = point.getSignature().getName();
        Object[] args = point.getArgs();

        // 发送异步日志事件
        long beginTime = System.currentTimeMillis();
        //执行方法
        Object result = point.proceed();
        //执行时长(毫秒)
        long time = System.currentTimeMillis() - beginTime;

        log.info("className = {}, methodName = {}, beginTime = {}, time = {}", className, methodName, beginTime, time);
        String method = WebUtil.getRequest().getMethod();
        point.proceed();
    }

}
