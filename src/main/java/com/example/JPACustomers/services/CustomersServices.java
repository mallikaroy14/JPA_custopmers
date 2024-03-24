package com.example.JPACustomers.services;


import com.example.JPACustomers.exceptional.EntityAlreadyExistsException;
import com.example.JPACustomers.exceptional.EntityNotFoundException;
import com.example.JPACustomers.model.Customers;
import com.example.JPACustomers.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersServices {

    @Autowired
    CustomerRepository customerRepository;

    public List<Customers> getAll() {
        return customerRepository.findAll();

    }

    public Customers addCustomers(Customers customers) {
        Optional<Customers> optionalCustomers = customerRepository.findByName(customers.getName());
        if (!optionalCustomers.isPresent()) {
            return customerRepository.save(customers);
        } else {
            throw new EntityAlreadyExistsException("This Customer already exists with this name");
        }
    }

    public String deleteCustomers(Long id) {
        Optional<Customers> optionalCustomers = customerRepository.findById(id);
        if (optionalCustomers.isPresent()) {
            customerRepository.deleteById(id);
            return "Product deleted successfully";
        } else {
            throw new EntityNotFoundException("This Customer does not exists");
        }

    }

    public Customers updateCustomer(Customers customers) {
        Optional<Customers> optionalCustomers = customerRepository.findById(customers.id);
        if (optionalCustomers.isPresent()) {
            optionalCustomers.get().setAge(customers.getAge());
            optionalCustomers.get().setCity(customers.getCity());
            optionalCustomers.get().setName(customers.getName());
            optionalCustomers.get().setPhone(customers.getPhone());
            Customers updatedCustomers = customerRepository.save(optionalCustomers.get());
            return updatedCustomers;
        } else {
            throw new EntityNotFoundException("This Customer does not not exists");
        }
    }
}
