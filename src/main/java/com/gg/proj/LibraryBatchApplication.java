package com.gg.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.gg.proj.config",
                                "com.gg.proj.consumer",
                                "com.gg.proj"})
public class LibraryBatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryBatchApplication.class, args);
    }

}
