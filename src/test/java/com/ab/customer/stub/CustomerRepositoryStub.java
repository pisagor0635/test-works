package com.ab.customer.stub;


import com.ab.customer.entity.Customer;
import com.ab.customer.repository.CustomerRepository;

import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryStub extends CustomerRepository {

    private Map<Long, Customer> customerList = new HashMap<>();

    @Override
    public void save(Customer customer) {
        customerList.put(customer.getId(), customer);
    }

    @Override
    public void delete(Long customerId) {
        customerList.remove(customerId);
    }

    @Override
    public Customer find(Long customerId) {
        return customerList.get(customerId);
    }

    public Map<Long, Customer> getCustomerList() {
        return customerList;
    }
}
