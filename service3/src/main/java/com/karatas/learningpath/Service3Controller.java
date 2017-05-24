package com.karatas.learningpath;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by bkaratas on 5/24/17.
 */
@RestController
public class Service3Controller {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/service-3/{consumer}", method = RequestMethod.POST)
    public String service3Controller(@PathVariable(value = "consumer") String consumer) {
        return "service3 running on port: " + serverPort + " consumer: " + consumer;
    }
}
