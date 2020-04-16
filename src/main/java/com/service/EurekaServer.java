package com.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaServer.class);
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer.class, args);
    }
}