package com.karatas.learningpath;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bkaratas on 5/24/17.
 */
@RestController
public class Service1Controller {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/service-1")
    public String service1Controller() {
        return "service1 running on port: " + serverPort;
    }

}
