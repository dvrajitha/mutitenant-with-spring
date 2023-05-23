package com.mutitenant.demo;

import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.PostgreSQLContainer;

@SpringBootTest
@Import(TestcontainersConfig.class)
class MutitenantApplicationTests {
    @Test
    void contextLoads() {
    }

}
