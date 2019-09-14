package com.qty.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ServiceProvider")
public interface helloService {

    @GetMapping(value = "/hello")
    String hello(@RequestParam("name")String name);
}
