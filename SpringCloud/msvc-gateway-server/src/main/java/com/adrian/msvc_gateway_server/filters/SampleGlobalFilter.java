package com.adrian.msvc_gateway_server.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class SampleGlobalFilter implements GlobalFilter, Ordered{

    private Logger logger = LoggerFactory.getLogger(SampleGlobalFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        
        logger.info("Ejecutando filtro antes del request");


        exchange.getRequest().mutate().headers(h -> h.add("token", "headerValue"));



        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            logger.info("ejecutando filtro POST");
            logger.info("token:" + exchange.getRequest().getHeaders().get("token"));

            

            exchange.getResponse().getCookies().add("color", ResponseCookie.from("color", "red").build());
            exchange.getResponse().getHeaders().setContentType(MediaType.TEXT_PLAIN);
        }));
        
    }

    @Override
    public int getOrder() {
       return 100;
    }

  


}

