package com.example.modulezuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 开启zuul的功能
 */
@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class ModuleZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleZuulApplication.class, args);
    }

}
