package aamm.order.service;

import aamm.order.Repository.CustomerRepository;
import aamm.order.config.JsonUtil;
import aamm.order.model.Customer;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CustomerService {
    @Autowired
    private RegisterValidator registerValidator;

    @Autowired
    private CustomerRepository customerRepo;

    
    public boolean register(Customer customer) {
        if(registerValidator.validate(customer)){
            return true;
        }else{
            return false;
        }
    }
    
    public Customer getCustomer(String name) {
        if (customerRepo.exists(name)) {
            return customerRepo.find(name);
        } else {
            return null;
        }
    }

    public boolean deleteCustomer(String name) {
        if (customerRepo.exists(name)) {
            customerRepo.delete(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateCustomer(String username, Customer customer) {
        if(customerRepo.exists(username)){
            customerRepo.update(customer);
            return true;
        }else{
            return false;
        }
    }

    public boolean deductBalance(String name, double amount) {
        Customer customer = customerRepo.find(name);
        if (customer.getBalance() < amount) {
            return false;
        }
        customer.setBalance(customer.getBalance() - amount);
        customerRepo.update(customer);
        return true;
    }

    public HashMap<String, Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
