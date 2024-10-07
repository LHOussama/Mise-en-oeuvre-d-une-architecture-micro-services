package com.example.billingservice.web;
import com.example.billingservice.entiites.Bill;
import com.example.billingservice.model.Customer;
import com.example.billingservice.repositoris.BillRepository;
import com.example.billingservice.repositoris.ProductItemRepository;
import com.example.billingservice.services.CustomerRestClient;
import com.example.billingservice.services.ProductRestClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@AllArgsConstructor
public class BillRestController {
    private final BillRepository billRepository;
    private final ProductRestClient productRestClient;
    private final CustomerRestClient customerRestClient;
    private ProductItemRepository productItemRepository;
    @GetMapping(path = "/fullBill/{id}")
    public Bill getBill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).orElseThrow(() -> new RuntimeException("Bill not found"));
        Customer customer=customerRestClient.getCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi->{
            pi.setProduct(productRestClient.getProductById(pi.getProductId()));
        });
        return bill;
    }
    @GetMapping(path = "/bills-customer/{id}")
    public List<Bill> getBillByCustomerId(@PathVariable Long id){
        billRepository.findBillByCustomerId(id).forEach(bill -> {
            Customer customer=customerRestClient.getCustomerById(bill.getCustomerId());
            bill.setCustomer(customer);
            bill.getProductItems().forEach(pi->{
                pi.setProduct(productRestClient.getProductById(pi.getProductId()));
            });
        });
        return billRepository.findBillByCustomerId(id);
    }

}
