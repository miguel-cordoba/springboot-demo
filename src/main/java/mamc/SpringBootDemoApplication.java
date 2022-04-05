package mamc;

import mamc.module.data.controller.SpringBootDemoController;
import mamc.module.data.model.Person;
import mamc.module.data.repositories.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan( basePackageClasses = {SpringBootDemoController.class, PersonRepository.class} )
public class SpringBootDemoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(SpringBootDemoApplication.class, args);
    }
}