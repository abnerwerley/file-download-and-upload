package com.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@EnableWebMvc
//@ComponentScan({"com.file.upload.controller , com.file.download.controller", "com.file.upload.service, com.file.download.service", "controller", "service"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
