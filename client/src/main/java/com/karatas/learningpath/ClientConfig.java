package com.karatas.learningpath;

import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bkaratas on 5/25/17.
 */
@Configuration
@EnableFeignClients(basePackages = "com.karatas.learningpath")
public class  ClientConfig {
}
