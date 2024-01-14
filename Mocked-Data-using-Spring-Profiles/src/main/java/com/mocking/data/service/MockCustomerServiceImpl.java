package com.mocking.data.service;
import com.mocking.data.mapper.MockCustomerData;
import com.mocking.data.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;


@Slf4j
@Service
public class MockCustomerServiceImpl implements CustomerService {

    private final MockCustomerData mockCustomerData;

    public MockCustomerServiceImpl(MockCustomerData mockCustomerData) {
        this.mockCustomerData = mockCustomerData;
    }

    public List<Customer> getCustomers() {

        return mockCustomerData.getMockCustomers();
    }

    public List<Customer> getCustomersByCity(String city) {
        return mockCustomerData.getMockCustomers().stream()
                .filter(customer -> customer.getAddress().getCity().equalsIgnoreCase(city))
                .toList();
    }

}
