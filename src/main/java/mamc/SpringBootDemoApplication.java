package mamc;

import mamc.module.data.model.Person;
import mamc.module.data.repositories.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("repositories")
public class SpringBootDemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =
                SpringApplication.run(mamc.SpringBootDemoApplication.class, args);

        PersonRepository pr = ctx.getBean(PersonRepository.class);
        Person p1 = new Person("Hola", "Caracola", "hola@caracola.com");
        Person p2 = new Person("La", "Rosalia", "tratra@gmail.com");

        pr.save(p1);
        pr.save(p2);
    }

}