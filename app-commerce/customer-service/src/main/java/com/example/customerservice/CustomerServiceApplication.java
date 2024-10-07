package com.example.customerservice;
import com.example.customerservice.entities.Customer;
import com.example.customerservice.repositories.CustomerRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;
@SpringBootApplication
public class CustomerServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(CustomerRepositorie customerRepositorie, RepositoryRestConfiguration restConfiguration){
        return  args -> {
            restConfiguration.exposeIdsFor(Customer.class);

            List.of("Mohamed","Ali","Salah","Khalil").forEach(c->{
                customerRepositorie.save(Customer.builder().nom(c).email(c+"@gmail.com").build());
            });
            customerRepositorie.findAll().forEach(System.out::println);
    };
    }

}
