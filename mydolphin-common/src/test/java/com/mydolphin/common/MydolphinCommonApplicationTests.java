package com.mydolphin.common;

import com.mydolphin.common.config.EnvAutoConfig;
import com.mydolphin.common.config.EnvConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MydolphinCommonApplicationTests {

    @Autowired
    EnvConfig envConfig;

    @Test
    public void contextLoads() {
        System.out.println(envConfig);
    }

}
