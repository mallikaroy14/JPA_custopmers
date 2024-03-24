package com.example.JPACustomers.services;

import com.example.JPACustomers.exceptional.EntityNotFoundException;
import com.example.JPACustomers.model.Products;
import com.example.JPACustomers.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServices {

    @Autowired
    ProductsRepository productsRepository;

    public List<Products> getAll() {
        return productsRepository.findAll();
    }

    public Products createProducts(Products products) {
        return productsRepository.save(products);
    }

    public String deleteProducts(Long id) {
        Optional<Products> optionalProducts = productsRepository.findById(id);
        if (optionalProducts.isPresent()){
            productsRepository.deleteById(id);
            return "Product is deleted Successfully";
        }else{
            throw new EntityNotFoundException("Product with this id does not exists");
        }
    }

    public Products updateProducts(Products products) {

        Optional<Products> optionalProducts = productsRepository.findById(products.getId());
        if (optionalProducts.isPresent()) {
            optionalProducts.get().setCategory(products.getCategory());
            optionalProducts.get().setName(products.getName());
            optionalProducts.get().setDescription(products.getDescription());
            optionalProducts.get().setPrice(products.getPrice());
            Products updatedProducts = productsRepository.save(optionalProducts.get());
            return updatedProducts;
        } else {
            throw new EntityNotFoundException("Product with this name not exists");
        }
    }

}
