package com.haizhang.hai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories(basePackages = {"com.haizhang.hai.bussiness.model.repository.**"})
@EntityScan(basePackages ={"com.haizhang.hai.bussiness.model.entity.**"})
@EnableAsync
public class HaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HaiApplication.class, args);
    }

}
