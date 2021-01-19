package com.xmb.workout.publisher;

import com.xmb.workout.event.ApiLogEvent;
import com.xmb.workout.log.entity.ApiLogEntity;
import com.xmb.workout.utils.SpringUtil;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Ben
 * @date 2021-01-19
 * @desc
 */
public class ApiLogPublisher {

    public static final String API_LOG = "ApiLog";

    public static void publishEvent(ApiLogEntity apiLogEntity) {

        Map<String, Object> event = new HashMap<>(16);
        event.put(API_LOG, apiLogEntity);
        SpringUtil.publishEvent(new ApiLogEvent(event));
    }

}
