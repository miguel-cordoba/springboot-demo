package mamc;

import ch.qos.logback.core.ContextBase;
import mamc.module.data.config.DataModuleConfiguration;
import mamc.module.data.controller.SpringBootDemoController;
import mamc.module.data.model.Person;
import mamc.module.data.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;

@SpringBootApplication
@ComponentScan( basePackageClasses = {SpringBootDemoController.class, PersonRepository.class} )
public class SpringBootDemoApplication {

    private static Environment env;
    private static ServerProperties sp;

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(mamc.SpringBootDemoApplication.class, args);

        PersonRepository pr = ctx.getBean(PersonRepository.class);
        Person p1 = new Person("Hola", "Caracola", "hola@caracola.com");
        Person p2 = new Person("La", "Rosalia", "tratra@gmail.com");

        pr.save(p1);
        pr.save(p2);
        env = ctx.getBean(Environment.class);
        sp = ctx.getBean(ServerProperties.class);
        System.out.println( "***** SE R V E ER:  "+ env.getProperty("server.port"));
        System.out.println( "***** SE R V E ER:  "+ sp.getPort());



    }

}