package com.xzinoviou.ssec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.xzinoviou.ssec"})
@SpringBootApplication
public class SsecApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsecApplication.class, args);
    }

}
