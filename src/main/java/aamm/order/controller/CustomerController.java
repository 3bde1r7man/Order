package aamm.order.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.config.JsonUtil;
import aamm.order.model.Customer;
import aamm.order.service.CustomerService;


@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{username}")
    public Object getCustomer(@PathVariable String username) {
        if (customerService.getCustomer(username) != null) {
            return customerService.getCustomer(username);
        } else {
            return JsonUtil.error("Customer does not exist");
        }
    }

    @DeleteMapping("/{username}")
    public Object deleteCustomer(@PathVariable String username) {
        if (customerService.deleteCustomer(username)) {
            return JsonUtil.success("Customer deleted successfully");
        } else {
            return JsonUtil.error("Customer does not exist");
        }
    }

    @PutMapping("/{username}")
    public Object updateCustomer(@PathVariable String username, @RequestBody Customer customer) {
        if (customerService.updateCustomer(username, customer)) {
            return JsonUtil.success("Customer updated successfully");
        } else {
            return JsonUtil.error("Customer does not exist");
        }
    }

    @GetMapping("")
    public Object getAllCustumers() {
        if (customerService.getAllCustomers() != null) {
            return customerService.getAllCustomers();
        } else {
            return JsonUtil.error("No customers found");
        }
    }
    
}
