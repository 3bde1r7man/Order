package aamm.order.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.model.Customer;
import aamm.order.service.CustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{name}")
    public Customer  getCustomer(@PathVariable String name) {
        return customerService.getCustomer(name);
    }

    @PostMapping("/delete/{name}")
    public boolean deleteCustomer(@PathVariable String name) {
        return customerService.deleteCustomer(name);
    }

    @PostMapping("/update")
    public boolean updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @GetMapping("/getallcustomers")
    public HashMap<String, Customer> getAllCustumers() {
        
        return customerService.getAllCustomers();
    }
    
}
