package com.mocking.data.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Address address;

}
