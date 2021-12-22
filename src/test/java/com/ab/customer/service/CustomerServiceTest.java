package com.ab.customer.service;

import com.ab.customer.entity.Customer;
import com.ab.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class CustomerServiceTest {

    private CustomerService customerService;
    private CustomerRepository customerRepository;
    private NotifyService notifyService;

    @BeforeEach
    public void setUp() {

        customerService = new CustomerService();

        customerRepository = Mockito.mock(CustomerRepository.class);
        notifyService = Mockito.mock(NotifyService.class);

        customerService.setNotifyService(notifyService);
        customerService.setCustomerRepository(customerRepository);

    }

    @Test
    public void testCustomerSave() {

        Customer customer = new Customer(1L);

        customerService.saveCustomer(customer);

        Mockito.verify(customerRepository).save(customer);
        Mockito.verify(notifyService).sendEmailForNewCostomerSaved(customer);

    }
}
