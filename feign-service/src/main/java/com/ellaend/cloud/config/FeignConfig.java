package com.ellaend.cloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ellaend
 * @date 2021/1/9 13:00
 * version 1.0
 * <p>
 * 日志级别
 * NONE：默认的，不显示任何日志；
 * BASIC：仅记录请求方法、URL、响应状态码及执行时间；
 * HEADERS：除了BASIC中定义的信息之外，还有请求和响应的头信息；
 * FULL：除了HEADERS中定义的信息之外，还有请求和响应的正文及元数据。
 * <p>
 * 作者：MacroZheng
 * 链接：https://juejin.cn/post/6844903959086235655
 */
@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
