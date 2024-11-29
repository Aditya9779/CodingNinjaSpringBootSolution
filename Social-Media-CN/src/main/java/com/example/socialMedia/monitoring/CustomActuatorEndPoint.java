package com.example.socialMedia.monitoring;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;

@Endpoint(id = "custom")
@Component
public class CustomActuatorEndPoint {
    @ReadOperation
//    public String customActuator(){
//        return "Custom Actuator";
//    }

    //HardCode
//    public HashMap<String,String> customActuator(){
//        HashMap<String,String> metricMap=new HashMap<>();
//        metricMap.put("Compute","70%");
//        metricMap.put("MemoryUsage","128gb");
//        return metricMap;
//    }

    /*http://localhost:8080/actuator/custom?memory=0*/  //for the passing the value in
    // the browser we use ? memory=34gb
    public HashMap<String,String> customActuator(String memory){
        HashMap<String,String> metricMap=new HashMap<>();
        metricMap.put("Compute","70%");
        metricMap.put("MemoryUsage",memory);
        return metricMap;
    }
}
