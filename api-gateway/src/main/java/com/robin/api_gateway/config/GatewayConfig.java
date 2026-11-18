package com.robin.api_gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("mclientes", r -> r
                        .path("/api/clientes1/**")
                        .uri("lb://MCLIENTES")  )
                .route("cclientes", r -> r
                        .path("/api/clientes2/**")
                        .uri("lb://CCLIENTES"))
                .build();
    }

}
