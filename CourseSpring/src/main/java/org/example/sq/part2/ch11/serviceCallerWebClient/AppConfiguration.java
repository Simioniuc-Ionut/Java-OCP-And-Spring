package org.example.sq.part2.ch11.serviceCallerWebClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfiguration {
    @Bean
    public WebClient webClient() {
        return WebClient
                .builder()
                .build();
    }

}
