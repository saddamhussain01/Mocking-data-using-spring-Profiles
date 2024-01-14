//package com.mocking.data.service;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mocking.data.model.Customer;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.util.Collections;
//import java.util.List;
//
//@Service
//@Slf4j
//public class realCustomerServiceImpl implements customerService{
//    @Override
//    public List<Customer> getCustomers() {
//        log.info("Fetching customers Details from real service.");
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            ClassPathResource resource = new ClassPathResource("real-customers.json");
//            return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Customer>>() {
//            });
//        } catch (IOException e) {
//            log.error("Error reading customer data from JSON file.", e);
//        }
//        return Collections.emptyList();
//
//    }
//}
