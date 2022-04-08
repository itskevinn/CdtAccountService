package com.kevcode.cdtsaccountservice.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Arrays;

@Configuration
public class CdtsAccountServiceConfiguration {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext context){
        return args -> {
            String[] beanNames = context.getBeanDefinitionNames();
            Arrays.sort(beanNames);

            for(String beanName: beanNames){
                System.out.println("BEAN:" + beanName);
            }
        };
    }
}
