package com.cn.trademaster.monitoring;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.composite.CompositeMeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Annotate the class with @Configuration annotation
@Configuration
public class MetricConfiguration {

 /**
  1. Create a method public MeterRegistry getMeterRegistry() and do the following:
    a. Create a "CompositeMeterRegistry" object and return it.
    b. Annotate the method with "Bean" annotation.
 **/@Bean
   public MeterRegistry getMeterRegistry() {
     return  new CompositeMeterRegistry();
  }

 }
