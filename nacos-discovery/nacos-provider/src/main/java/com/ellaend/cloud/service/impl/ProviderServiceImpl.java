package com.ellaend.cloud.service.impl;

import com.ellaend.cloud.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private Environment environment;

    public String get(String name) {
        String port = environment.getProperty("local.server.port");
        logger.info("当前服务端口号：" + port + "调用方法：" + "get");
        return "Hello " + name + "!  来自端口号" + port + "提供的服务";
    }

}
