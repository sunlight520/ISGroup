package com.is.isgroup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class IsGroupApplication {
    public static void main(String[] args) {
        SpringApplication.run(IsGroupApplication.class, args);
    }
}
