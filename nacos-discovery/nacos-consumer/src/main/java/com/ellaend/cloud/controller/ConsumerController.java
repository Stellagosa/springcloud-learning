package com.ellaend.cloud.controller;

import com.ellaend.cloud.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumer/{name}")
    public String get(@PathVariable String name) {
        return consumerService.get(name);
    }

}
