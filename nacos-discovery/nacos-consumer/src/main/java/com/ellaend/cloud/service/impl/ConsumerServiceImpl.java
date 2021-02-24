package com.ellaend.cloud.service.impl;

import com.ellaend.cloud.service.ConsumerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private RestTemplate restTemplate;
    @Value("${service-url.nacos-provider}")
    private String serviceUrl;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Override
    public String get(String name) {
        logger.info("调用服务");
        return restTemplate.getForObject(serviceUrl + "/provider/{name}", String.class, name);
    }
}
