package com.ellaend.cloud.controller;

import com.ellaend.cloud.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProviderController {

    @Autowired
    private ProviderService providerService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/provider/{name}")
    public String getMsg(@PathVariable String name) {
        logger.info("ProviderController的getMsg()方法提供服务");
        return providerService.get(name);
    }

}
