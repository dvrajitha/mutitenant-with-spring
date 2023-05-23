package com.mutitenant.demo;

import org.springframework.boot.SpringApplication;

public class MutitenantApplicationWithTestContainers {
    public static void main(String[] args) {
        SpringApplication.from(MutitenantApplication::main)
                .with(TestcontainersConfig.class)
                .run(args);
    }
}
