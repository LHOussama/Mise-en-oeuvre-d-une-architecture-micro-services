package com.example.envontoryservice;
import com.example.envontoryservice.entities.Product;
import com.example.envontoryservice.repositories.ProductRepositori;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import java.util.List;
@SpringBootApplication
public class EnvontoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EnvontoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(ProductRepositori productRepo, RepositoryRestConfiguration configuration){
        configuration.exposeIdsFor(Product.class);
        return  args -> {
            productRepo.saveAll(List.of(
                    new Product(null,"Ordinateur",788,12),
                    new Product(null,"Imprimante",88,122),
                    new Product(null,"Smartphone",788,12),
                    new Product(null,"Tablette",788,12),
                    new Product(null,"Disque Dur",788,12),
                    new Product(null,"Cle USB",788,12),
                    new Product(null,"Camera",788,12),
                    new Product(null,"Scanner",788,12),
                    new Product(null,"Ecran",788,12),
                    new Product(null,"Souris",788,12),
                    new Product(null,"Clavier",788,12),
                    new Product(null,"Casque",788,12)));
        };

    }

}
