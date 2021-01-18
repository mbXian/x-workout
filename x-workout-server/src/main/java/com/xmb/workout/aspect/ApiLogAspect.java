package com.xmb.workout.aspect;

import com.alibaba.fastjson.JSON;
import com.xmb.workout.annotation.ApiLog;
import com.xmb.workout.log.constant.LogTypeEnum;
import com.xmb.workout.log.entity.ApiLogEntity;
import com.xmb.workout.log.service.ApiLogService;
import com.xmb.workout.utils.network.WebUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.util.Date;

/**
 * @author Ben
 * @date 2021-01-18
 * @desc
 */
@Slf4j
@Component
@Aspect
public class ApiLogAspect {

    @Autowired
    private ApiLogService apiLogService;
    @Value("${spring.application.name}")
    private String applicationName;
    @Value("${spring.profiles.active}")
    private String profilesActive;

    @Around(value = "@annotation(apiLog)")
    public void around(ProceedingJoinPoint point, ApiLog apiLog) throws Throwable {

        //服务器信息
        InetAddress address = InetAddress.getLocalHost();
        //服务id
        String serverId = applicationName;
        //服务器host
        String hostName = address.getHostName();
        //服务器IP
        String serverIp = address.getHostAddress();
        //服务器环境
        String env = profilesActive;
        //日志类型
        Integer type = LogTypeEnum.API_LOG.getIndex();
        //日志标题
        String title = apiLog.title();
        //请求方式
        String method = WebUtil.getRequest().getMethod();
        //请求Url
        String requestURI = WebUtil.getRequest().getRequestURI();
        //请求端的host
        String remoteHost = WebUtil.getRequest().getRemoteHost();
        //请求端IP地址
        String remoteIp = WebUtil.getRemortIP(WebUtil.getRequest());
        //获取类名
        String className = point.getTarget().getClass().getName();
        //获取方法
        String methodName = point.getSignature().getName();
        //请求提交的参数
        String params = null;
        if ("GET".equals(method)) {
            params = WebUtil.getRequestContent(WebUtil.getRequest());
        } else if ("POST".equals(method)) {
            Object[] args = point.getArgs();

            for (int i = 0; i < args.length; i++) {
                if (params == null) {
                    params = "";
                }
                params += JSON.toJSONString(args[i]);
            }
        }
        //执行开始时间
        Date startTime = new Date();
        //执行方法
        Object result = point.proceed();
        String resultJsonString = null;
        if (result != null) {
            resultJsonString = JSON.toJSONString(result);
        }
        //执行结束时间
        Date endTime = new Date();

        ApiLogEntity apiLogEntity = new ApiLogEntity();
        apiLogEntity.setServiceId(serverId);
        apiLogEntity.setServerHost(hostName);
        apiLogEntity.setServerIp(serverIp);
        apiLogEntity.setEnv(env);
        apiLogEntity.setType(type);
        apiLogEntity.setTitle(title);
        apiLogEntity.setMethod(method);
        apiLogEntity.setRequestUri(requestURI);
        apiLogEntity.setRemoteHost(remoteHost);
        apiLogEntity.setRemoteIp(remoteIp);
        apiLogEntity.setMethodClass(className);
        apiLogEntity.setMethodName(methodName);
        apiLogEntity.setParams(params);
        apiLogEntity.setResult(resultJsonString);
        apiLogEntity.setStartTime(startTime);
        apiLogEntity.setEndTime(endTime);
        apiLogService.save(apiLogEntity);
    }

}
