package aamm.order.controller;
import aamm.order.model.Customer;

import aamm.order.service.CustomerService;
//import aamm.order.service.SimpleOrderService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("")
public class APPcontroller {
    @Autowired
    private CustomerService customerService;
    // @Autowired
    // private SimpleOrderService simpleOrderService;



    @PostMapping("/register")
    public boolean register(@RequestBody Customer customer) {
        if (customer != null) {
            return customerService.register(customer);
        } else {
            return false;
        }
    }


    @PostMapping("/login/{userName}/{password}")
    public boolean login(@PathVariable String userName, @PathVariable String password){
        return customerService.login(userName, password);
    }

    // @PostMapping("/place-simple-order")
    // public boolean placeSimpleOrder(@RequestBody SimpleOrder order) {
    //     if(order != null){
    //         simpleOrderService.placeOrder(order);

    //         return true;
    //     }else{
    //         return false;
    //     }
    // }

    // @GetMapping("/get-order/{id}")
    // public Order getOrder(@PathVariable int id) {
    //     return simpleOrderService.getOrder(id);
    // }
    
    
}
