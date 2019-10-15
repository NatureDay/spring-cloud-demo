package com.example.moduleserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ModuleServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleServerApplication.class, args);
    }

}
