package com.xmb.workout.utils.network;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RequestParams {
    public ConcurrentHashMap<String,String> urlParams = new ConcurrentHashMap<>();
    public ConcurrentHashMap<String,Object> fileParams = new ConcurrentHashMap<>();


    public RequestParams(Map<String,String> souce){
        if (souce!=null){
            for (Map.Entry<String,String> entry : souce.entrySet()){
                put(entry.getKey(),entry.getValue());
            }
        }
    }

    public RequestParams(final String key , final String value) {
        this(new HashMap<String, String>(){
            {
                put(key, value);
            }
        });

    }

    public void put(String key , String value){
        if(key!=null && value!=null){
            urlParams.put(key, value);
        }
    }

    public void put(String key , Object value){
        if(key!=null && value!=null){
            fileParams.put(key, value);
        }
    }

    public boolean hasParams(){
        return urlParams.size() > 0 || fileParams.size() > 0;
    }

}
