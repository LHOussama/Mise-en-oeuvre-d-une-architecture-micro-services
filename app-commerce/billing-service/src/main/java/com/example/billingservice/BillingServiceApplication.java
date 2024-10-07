package com.example.billingservice;

import com.example.billingservice.entiites.Bill;
import com.example.billingservice.entiites.ProductItems;
import com.example.billingservice.model.Customer;
import com.example.billingservice.model.Product;
import com.example.billingservice.repositoris.BillRepository;
import com.example.billingservice.repositoris.ProductItemRepository;
import com.example.billingservice.services.CustomerRestClient;
import com.example.billingservice.services.ProductRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@EnableFeignClients
@SpringBootApplication
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository, ProductItemRepository productItemRepository,
                                        CustomerRestClient customerRestClient,
                                        ProductRestClient productRestClient) {
        return args -> {
            Collection<Product> products=productRestClient.allProducts().getContent();
            Long customoerId=1L;
            Customer customer=customerRestClient.getCustomerById(customoerId);
            System.out.println(customer.toString());
            if (customer==null) throw new RuntimeException("Customer not found");
            Bill  bill=new Bill();
            bill.setCustomerId(customoerId);
            bill.setBillingDate(new Date());
            Bill save = billRepository.save(bill);
            System.out.println(save);
            products.forEach(p->{
                ProductItems productItems=new ProductItems();
                productItems.setPrice(p.getPrice());
                productItems.setQuantity(1);
                productItems.setProductId(p.getId());
                productItems.setBill(save);
                productItems.setDiscount(Math.random());
                productItemRepository.save(productItems);
            });
        };
    }
}
