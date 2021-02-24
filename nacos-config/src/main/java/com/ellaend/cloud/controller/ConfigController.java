package com.ellaend.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * RefreshScope：保证在不重启服务的时候能够及时刷新
 */
@RestController
@RefreshScope
public class ConfigController {

    @Value("${message:null}")
    private String msg;

    @GetMapping("/msg")
    public String getMsg() {
        return this.msg;
    }

}
