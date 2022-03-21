package mamc.module.data.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DataModuleConfiguration {

    @Bean
    String getServicePort(final Environment environment) {
        return environment.getProperty("server.port");
    }







}
