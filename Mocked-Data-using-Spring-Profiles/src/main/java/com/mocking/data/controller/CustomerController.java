package com.mocking.data.controller;

import com.mocking.data.model.Customer;

import com.mocking.data.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        log.info("Request received to fetch customers.");
        List<Customer> customers = customerService.getCustomers();
        log.debug("Fetched {} customers from the service.", customers.size());
        return customers;
    }

    @GetMapping("/customers/{city}")
    public List<Customer> getCustomersByCity(@PathVariable String city){
       return customerService.getCustomersByCity(city);
    }
}
