package com.gg.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gg.proj.config"})
public class LibraryBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryBatchApplication.class, args);
    }

}
