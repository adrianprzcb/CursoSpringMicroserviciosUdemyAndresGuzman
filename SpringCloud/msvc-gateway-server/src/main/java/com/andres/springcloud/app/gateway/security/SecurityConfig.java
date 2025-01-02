package com.andres.springcloud.app.gateway.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

import io.netty.handler.codec.http.HttpObject;

@Configuration
public class SecurityConfig {


    @Bean
    SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) throws Exception{
        return http.authorizeExchange(authz -> {
            authz.pathMatchers("/authorized", "/logout").permitAll()
            .pathMatchers(HttpMethod.GET , "api/items" , "/api/products" , "api/users").permitAll()
            .pathMatchers(HttpMethod.GET , "api/items/{id}" , "api/products/{id}" , "api/users/{id}").hasAnyRole("ADMIN", "USER")
            .pathMatchers("/api/products/**", "/api/items/**", "/api/users/**").hasRole("ADMIN")
            .pathMatchers(HttpMethod.POST,"/api/products", "/api/items", "/api/users").hasRole("ADMIN")
            .pathMatchers(HttpMethod.PUT,"/api/products/{id}", "/api/items/{id}", "/api/users/{id}").hasRole("ADMIN")
            .pathMatchers(HttpMethod.DELETE, "/api/products/{id}", "/api/items/{id}", "/api/users/{id}").hasRole("ADMIN")

        })
    }

}
