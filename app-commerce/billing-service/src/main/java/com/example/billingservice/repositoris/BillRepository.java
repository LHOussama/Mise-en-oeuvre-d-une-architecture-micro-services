package com.example.billingservice.repositoris;
import com.example.billingservice.entiites.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    public List<Bill> findBillByCustomerId(Long id);
}
