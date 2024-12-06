package com.adrian.msvc_gateway_server.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SampleGlobalFilter implements GlobalFilter{

    private Logger logger = LoggerFactory.getLogger(SampleGlobalFilter.class)

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        
        logger.info("Ejecutando filtro antes del request");

        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            logger.info("ejecutando filtro POST");
        }));
        
    }

    

}
