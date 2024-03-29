package com.ellaend.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customizeRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes().route("path_route2", r -> r.path("/user/getByUsername")
                .uri("http://localhost:8201/user/getByUsername")).build();
    }

}
