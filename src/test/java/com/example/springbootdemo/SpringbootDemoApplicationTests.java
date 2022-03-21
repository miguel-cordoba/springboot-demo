package com.example.springbootdemo;

import mamc.module.data.config.DataModuleConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {
        DataModuleConfiguration dmc = new DataModuleConfiguration();
        //String serverPort = dmc.getServicePort();

    }

}
