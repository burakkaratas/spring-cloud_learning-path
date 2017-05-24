package com.karatas.learningpath;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by bkaratas on 5/24/17.
 */
@RestController
public class Service2Controller {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/service-2", method = RequestMethod.GET)
    public String service2Controller(@RequestParam(value = "consumer") String consumer) {
        return "service2 running on port: " + serverPort + " consumer: " + consumer;
    }
}
