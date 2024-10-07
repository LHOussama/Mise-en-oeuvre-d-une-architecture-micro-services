package com.example.customerservice.entities;
import org.springframework.data.rest.core.config.Projection;
@Projection(name = "nomClient",types =Customer.class)
public interface Customer_projection {
    public String getNom();
    public Long getId();
}

