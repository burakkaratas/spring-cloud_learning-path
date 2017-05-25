package com.karatas.learningpath;

import com.karatas.learningpath.clients.Service2Client;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bkaratas on 5/24/17.
 */
@RestController
@Slf4j
public class Service1Controller {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private Service2Client service2Client;

    @RequestMapping("/service-1")
    public String service1Controller() {

        final Application service2 = eurekaClient.getApplication("service-2");
        for (InstanceInfo instanceInfo : service2.getInstances()) {
            System.out.println(instanceInfo.getHealthCheckUrls());
        }

        final List<ServiceInstance> instances = discoveryClient.getInstances("service-2");

        for (ServiceInstance intance : instances) {
            System.out.println(intance.getUri());
        }

        final ServiceInstance serviceInstance = loadBalancerClient.choose("service-2");
        System.out.println(serviceInstance.getUri());

        final String response = service2Client.service2Controller("tute");
        System.out.println(response);

        return "service1 running on port: " + serverPort;
    }

}
