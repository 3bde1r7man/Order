package aamm.order.service;

import aamm.order.Repository.CustomerRepository;
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
        return customerRepo.find(name);
    }

    public boolean deleteCustomer(String name) {
        if(customerRepo.exists(name)){
            customerRepo.delete(name);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateCustomer(Customer customer) {
        if(customerRepo.exists(customer.getName())){
            customerRepo.update(customer);
            return true;
        }else{
            return false;
        }
    }

    public void deductBalance(String name, double amount) {
        Customer customer = customerRepo.find(name);
        customer.setBalance(customer.getBalance() - amount);
        customerRepo.update(customer);
    }
    public boolean login(String userName, String password){
        if(customerRepo.exists(userName)){
            return customerRepo.find(userName).getPassword().equals(password);
        }
        return false;
    }

    public HashMap<String, Customer> getAllCustomers() {
        return customerRepo.findAll();
    }
}
