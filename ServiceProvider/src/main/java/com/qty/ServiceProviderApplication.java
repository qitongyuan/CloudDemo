package com.qty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceProviderApplication {


    @Slf4j
    @RestController
    static class TestController {
        @GetMapping("/hello")
        public String hello(String name) {
            log.info("name:{}", name);
            return "hello " + name+"调用服务端成功";
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderApplication.class,args);
    }
}
