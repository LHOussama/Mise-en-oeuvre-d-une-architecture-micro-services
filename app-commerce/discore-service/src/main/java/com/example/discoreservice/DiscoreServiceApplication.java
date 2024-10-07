package com.example.discoreservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@SpringBootApplication
@EnableEurekaServer
public class DiscoreServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DiscoreServiceApplication.class, args);
    }

}
