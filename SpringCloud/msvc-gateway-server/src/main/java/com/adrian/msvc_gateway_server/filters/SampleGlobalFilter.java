package com.adrian.msvc_gateway_server.filters;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SampleGlobalFilter implements GlobalFilter{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'filter'");
    }

    

}
