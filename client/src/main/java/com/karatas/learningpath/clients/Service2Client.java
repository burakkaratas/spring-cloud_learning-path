package com.karatas.learningpath.clients;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by bkaratas on 5/25/17.
 */
@FeignClient("service-2")
public interface Service2Client {
     @RequestMapping(value = "/service-2", method = RequestMethod.GET)
    String service2Controller(@RequestParam(value = "consumer") String consumer);
}
