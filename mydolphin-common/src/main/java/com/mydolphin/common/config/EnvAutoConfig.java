package com.mydolphin.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertyResolver;

@Configuration
@ConditionalOnClass(PropertyResolver.class)
public class EnvAutoConfig {
    @Bean
    public EnvConfig envConfig(){
        return new EnvConfig();
    }
}
