package com.mydolphin.common.config;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class EnvConfig implements EnvironmentAware {
    private Environment environment;

    public String getStringValue(String key){
        return environment.getProperty(key);
    }

//    public Long getLongValue(String key){
//        String value = getStringValue(key);
//        return Long.parseLong(value);
//    }

//    public Integer getIntegerValue(String key){
//        String value = getStringValue(key);
//        return Integer.parseInt(value);
//    }



    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
