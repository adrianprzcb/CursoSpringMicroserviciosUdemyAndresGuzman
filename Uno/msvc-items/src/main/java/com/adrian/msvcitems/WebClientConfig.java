package com.adrian.msvcitems;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    WebClient.Builder webClient() {
        return WebClient.builder();
    }
}
