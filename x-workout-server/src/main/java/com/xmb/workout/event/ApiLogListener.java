package com.xmb.workout.event;

import com.xmb.workout.log.entity.ApiLogEntity;
import com.xmb.workout.log.service.ApiLogService;
import com.xmb.workout.publisher.ApiLogPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * @author Ben
 * @date 2021-01-19
 * @desc
 */
@Slf4j
@Component
public class ApiLogListener {

    @Autowired
    private ApiLogService apiLogService;

    @Async
    @Order
    @EventListener(ApiLogEvent.class)
    public void saveApiLog(ApiLogEvent event) {
        Map<String, Object> source = (Map<String, Object>) event.getSource();
        ApiLogEntity apiLogEntity = (ApiLogEntity)source.get(ApiLogPublisher.API_LOG);
        apiLogService.save(apiLogEntity);
    }

}

