package com.example.JPACustomers.controllers;


import com.example.JPACustomers.model.Products;
import com.example.JPACustomers.services.ProductServices;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductsController {

    @Autowired
    ProductServices productServices;

    @GetMapping("/")
    public List<Products> getAll() {
        return productServices.getAll();
    }

    @PostMapping("/")
    public Products createProducts(@RequestBody Products products) {
        return productServices.createProducts(products);
    }

    @DeleteMapping("/{id}")
    public String deleteProducts(@PathVariable Long id){
        return productServices.deleteProducts(id);

    }

    @PutMapping("/update")
    public Products updateProducts(@RequestBody Products products){
        return productServices.updateProducts(products);
    }


}
