package com.airsys.airticket.service;

import com.airsys.airticket.entity.Customer;
import com.airsys.airticket.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired private CustomerRepository customerRepository;
    @Override
    public Customer saveCust(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> saveAllCust() {
        return  customerRepository.findAll();
    }
}
