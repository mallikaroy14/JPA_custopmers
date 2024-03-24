package com.example.JPACustomers.controllers;

import com.example.JPACustomers.model.Customers;
import com.example.JPACustomers.services.CustomersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
public class CustomerControllers {

    @Autowired
    CustomersServices customersServices;

    @GetMapping("/")
    public List<Customers> getAll(){
        return customersServices.getAll();
    }

    @PostMapping("/")
    public Customers addCustomers(@RequestBody Customers customers){
       return customersServices.addCustomers(customers);
    }

    @DeleteMapping("/{id}")
    public String deleteCustomers(@PathVariable Long id){
       return customersServices.deleteCustomers(id);
    }

    @PutMapping("/")
    public Customers updateCustomers(@RequestBody Customers customers){
        return customersServices.updateCustomer(customers);
    }

}
