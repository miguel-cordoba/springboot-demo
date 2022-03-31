package com.example.springbootdemo;

import mamc.module.data.config.DataModuleConfiguration;
import mamc.module.data.model.Person;
import mamc.module.data.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;


@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {
        DataModuleConfiguration dmc = new DataModuleConfiguration();

    }

    @Test
    void shouldSaveThisEntity(){
        Person person = new Person("La", "Rosalia", "tratra@gmail.com");




    }

}
