package com.github.meixuesong.hibernatespike;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories("com.github.meixuesong.hibernatespike")
@EnableTransactionManagement
public class HibernateCacheSpikeApplication {

    public static void main(String[] args) {
        SpringApplication.run(HibernateCacheSpikeApplication.class, args);
    }

}
