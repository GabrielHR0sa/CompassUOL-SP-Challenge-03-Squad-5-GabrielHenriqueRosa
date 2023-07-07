package br.com.compassuol.pb.challenge.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){

        return builder.routes()
                .route("ms-products", r -> r
                        .path("/users/login")
                        .uri("http://localhost:8082/"))
                .route("ms-products", r -> r
                        .path("/users")
                        .uri("http://localhost:8082/"))
                .route("ms-products", r -> r
                        .path("/users/{id}")
                        .uri("http://localhost:8082/"))
                .route("ms-products", r -> r
                        .path("/products")
                        .uri("http://localhost:8082/"))
                .route("ms-products", r -> r
                        .path("/products/{id}")
                        .uri("http://localhost:8082/"))
                .route("ms-products", r -> r
                        .path("/categories")
                        .uri("http://localhost:8082/"))
                .route("ms-products", r -> r
                        .path("/categories/{id}")
                        .uri("http://localhost:8082/"))
                .build();
    }
}
