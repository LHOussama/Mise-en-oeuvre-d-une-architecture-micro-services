package com.example.envontoryservice.repositories;

import com.example.envontoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepositori extends JpaRepository<Product,Long> {
}
