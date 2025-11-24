package org.example.sq.ch4.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"org.example.sq.ch4.services","org.example.sq.ch4.repositories","org.example.sq.ch4.proxies"})
public class ProjectConfiguration {

}
