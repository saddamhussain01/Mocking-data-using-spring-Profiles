package com.mocking.data.mapper;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mocking.data.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Component
@Slf4j
@Profile({"dev", "test", "acc", "prod"})
public class MockCustomerData {

    private final List<Customer> mockCustomers;

    public MockCustomerData(ResourceLoader resourceLoader, @Value("${mock.data.path}") String mockDataPath) {
        this.mockCustomers = loadMockedCustomers(resourceLoader, mockDataPath);
    }

    private List<Customer> loadMockedCustomers(ResourceLoader resourceLoader, String mockDataPath) {
        log.info("Fetching customers details using spring profiles.");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Resource resource = resourceLoader.getResource(mockDataPath);
            return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<Customer>>() {});
        } catch (IOException e) {
            log.error("Error reading customer data from JSON file.", e);
        }
        return Collections.emptyList();
    }

    public List<Customer> getMockCustomers() {
        return mockCustomers;
    }
}
