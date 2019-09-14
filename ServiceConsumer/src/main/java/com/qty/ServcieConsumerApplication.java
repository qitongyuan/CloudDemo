package com.qty;

import com.qty.FeignClients.helloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ServcieConsumerApplication {

    @Slf4j
    @RestController
    static class TestController {

        @Autowired
        helloService helloService;

        @GetMapping("/getUserName")
        public String getUserName(String name){
            String res= helloService.hello(name);
            log.info("客户端调用的结果:{}",res);
            return res;
        }


    }

    public static void main(String[] args) {
        SpringApplication.run(ServcieConsumerApplication.class,args);
    }
}
