package aamm.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import aamm.order.InMemDB;
import aamm.order.service.RegisterValidator;


@Configuration
public class AppConfig {

    @Bean
    public InMemDB inMemDB() {
        return new InMemDB();
    }

    @Bean
    public RegisterValidator registerValidator(InMemDB inMemDB) {
        return new RegisterValidator(inMemDB);
    }
}