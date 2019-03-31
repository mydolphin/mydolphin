package cn.mydolphin.gateway;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class MydolphinGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MydolphinGatewayApplication.class, args);
    }
}
