package aamm.order.controller;
import aamm.order.config.JsonUtil;
import aamm.order.model.Customer;

import aamm.order.service.CustomerService;
//import aamm.order.service.SimpleOrderService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("")
public class APPcontroller {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/register")
    public Object register(@RequestBody Customer customer) {
        if (customerService.register(customer)) {
            return JsonUtil.success("Customer registered successfully");
        } else {
            return JsonUtil.error("Customer already exists");
        }
    }
    
}
