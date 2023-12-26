package aamm.order.service;

import aamm.order.DB;
import aamm.order.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    @Autowired
    private RegisterValidator registerValidator;

    @Autowired
    private DB DB;

    
    public boolean register(Customer customer) {
        if(registerValidator.validate(customer)){
            return true;
        }else{
            return false;
        }
    }
    
    public Customer getCustomer(String name) {
        return DB.getCustomer(name);
    }
}
