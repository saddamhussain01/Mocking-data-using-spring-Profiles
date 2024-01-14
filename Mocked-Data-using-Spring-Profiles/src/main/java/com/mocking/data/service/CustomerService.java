package com.mocking.data.service;

import com.mocking.data.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> getCustomers();

    List<Customer> getCustomersByCity(String city);

}
