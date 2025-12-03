package org.example.sq.part2.ch11.serviceCallerOpenFeign;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(
        basePackages = "org.example.sq.part2.ch11"
)
public class AppConfiguration {

}
