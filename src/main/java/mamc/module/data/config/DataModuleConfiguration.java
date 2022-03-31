package mamc.module.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;

import javax.persistence.EntityManagerFactory;

@Configuration
@EnableJpaRepositories
public class DataModuleConfiguration {

    @Bean
    String getServicePort(final Environment environment) {
        return environment.getProperty("server.port");
    }

    //@Bean
    //public JpaTransactionManager transactionManager(EntityManagerFactory emf){
      //  return new JpaTransactionManager(emf);
    //}






}
