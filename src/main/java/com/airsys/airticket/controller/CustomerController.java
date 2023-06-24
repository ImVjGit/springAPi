package com.airsys.airticket.controller;

import com.airsys.airticket.entity.Customer;
import com.airsys.airticket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AirBooking/customer")
public class CustomerController {
    @Autowired private CustomerService customerService;
    @PostMapping("/savecustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
        Customer savedCustomer=customerService.saveCust(customer);
        return savedCustomer;
    }

    @GetMapping("/showAllcustomer")
    public List<Customer> showCustomer(){
        List<Customer> listCustomer=customerService.saveAllCust();
        return listCustomer;
    }

}
