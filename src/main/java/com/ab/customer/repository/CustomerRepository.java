package com.ab.customer.repository;

import com.ab.customer.entity.Customer;

public class CustomerRepository {

    public void save(Customer customer) {
        System.out.println("Customer saved!");
    }

    public void delete(Long customerId) {
        System.out.println("customer deleted");
    }

    public Customer find(Long customerId) {
        System.out.println("customer finded");

        return null;
    }
}
