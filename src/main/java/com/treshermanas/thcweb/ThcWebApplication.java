package com.treshermanas.thcweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ThcWebApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(ThcWebApplication.class, args);
    }

}
