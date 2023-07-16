package org.j2os;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FindPersonServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(FindPersonServiceApplication.class, args);
    }
}
