package aamm.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import aamm.order.Repository.*;
import aamm.order.service.RegisterValidator;



@Configuration
public class AppConfig {

    @Bean
    public CategoryRepository categoryRepository() {
        return new CategoryRepositoryInMem();
    }

    @Bean
    public ProductRepository productRepository() {
        return new ProductRepositoryInMem();
    }
    
    @Bean
    public CustomerRepository customerRepository() {
        return new CustomerRepositoryInMem();
    }

    @Bean
    public OrderRepository orderRepository() {
        return new OrderRepositoryInMem();
    }

}
