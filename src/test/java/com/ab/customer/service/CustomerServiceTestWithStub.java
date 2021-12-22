package com.ab.customer.service;

import com.ab.customer.entity.Customer;
import com.ab.customer.stub.CustomerRepositoryStub;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CustomerServiceTestWithStub {

    private CustomerService customerService;
    private CustomerRepositoryStub customerRepository;
    private NotifyService notifyService;

    @BeforeEach
    public void setUp() {

        customerService = new CustomerService();

        customerRepository = new CustomerRepositoryStub();

        notifyService = Mockito.mock(NotifyService.class);

        customerService.setNotifyService(notifyService);
        customerService.setCustomerRepository(customerRepository);

    }

    @Test
    public void testCustomerSave() {
        Customer customer = new Customer(1L);
        customerService.saveCustomer(customer);
        Assertions.assertEquals(customer, customerRepository.find(customer.getId()));
    }

    @Test
    public void testDeleteCustomer(){

        Customer customer = new Customer(1L);
        customerService.saveCustomer(customer);
        customerService.deleteCustomer(customer.getId());
        Assertions.assertNull(customerRepository.find(customer.getId()));

    }


}
