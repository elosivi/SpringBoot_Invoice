package com.mycompany.invoise;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {
        "com.mycompany.invoise.controller.web",
        "com.mycompany.invoise.repository.database",
        "com.mycompany.invoise.service.prefix"})
@PropertySource("classpath:application.properties")
@ImportResource("classpath:applicationContext.xml")// pas nécessaire si @ComponentScan
public class AppConfig {
}
