package com.ab.customer.service;

import com.ab.customer.entity.Customer;
import com.ab.customer.repository.CustomerRepository;

public class CustomerService {

    private CustomerRepository customerRepository;
    private NotifyService notifyService;

    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
        notifyService.sendEmailForNewCostomerSaved(customer);
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.delete(customerId);
    }

    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void setNotifyService(NotifyService notifyService) {
        this.notifyService = notifyService;
    }
}
