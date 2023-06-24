package com.airsys.airticket.service;

import com.airsys.airticket.entity.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCust(Customer customer);

    List<Customer> saveAllCust();
}
