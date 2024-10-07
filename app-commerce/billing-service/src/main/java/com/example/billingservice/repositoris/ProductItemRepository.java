package com.example.billingservice.repositoris;
import com.example.billingservice.entiites.ProductItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItems, Long> {

}
