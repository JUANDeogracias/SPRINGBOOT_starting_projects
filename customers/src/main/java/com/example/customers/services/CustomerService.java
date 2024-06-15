package com.example.customers.services;

import com.example.customers.entities.Customer;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

public interface CustomerService {
    public Customer getCustomer(Integer id);
    public List<Customer> getAllCustomers();
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer updateCustomer, Integer id);
    public void removeCustomer(Integer id);
    public List<Customer> searchCustomer(String francesco, String address);
}

