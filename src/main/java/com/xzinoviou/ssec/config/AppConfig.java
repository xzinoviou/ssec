package com.xzinoviou.ssec.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.xzinoviou.ssec"})
public class AppConfig {
}
