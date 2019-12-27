package com.paga;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(exclude = {MongoAutoConfiguration.class})
@EnableTransactionManagement
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class,args);
    }

}
