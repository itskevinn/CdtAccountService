package com.kevcode.cdtsaccountservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CdtsAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CdtsAccountServiceApplication.class, args);
    }

}
