package com.JinAlYang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JinAlYangApplication {

    public static void main(String[] args) {
        SpringApplication.run(JinAlYangApplication.class, args);
    }

}