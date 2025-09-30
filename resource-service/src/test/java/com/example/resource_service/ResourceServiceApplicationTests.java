package com.example.resource_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {
    "com.example.resource_service",
    "com.example.resource_service.repository"
})
@DataJpaTest
class ResourceServiceApplicationTests {

    @Test
    void contextLoads() {
    }

}
