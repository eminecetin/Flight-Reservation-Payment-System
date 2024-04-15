package com.booking.apigateway.config;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        return builder.routes()
                .route("flight-service-route", r->
                        r.path("/flight-service/**")
                                .filters(f->f
                                        .rewritePath("/flight-service/(?<segment>.*)","/${segment}"))
                                .uri("lb://flight-service"))
                .route("nlp-service-route",r->r.path("/nlp-service/**")
                        .filters(f->f.rewritePath("/nlp-service/(?<segment>.*)", "${segmemnt}"))
                        .uri("lb://nlp-service"))
                .build();
    }
}
