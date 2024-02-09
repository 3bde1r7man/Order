package aamm.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.CustomerRepository;
import aamm.order.model.Customer;


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
        if (customerRepo.existsById(name)) {
            return customerRepo.findById(name).get();
        } else {
            return null;
        }
    }

    public boolean deleteCustomer(String name) {
        if (customerRepo.existsById(name)) {
            customerRepo.deleteById(name);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateCustomer(String username, Customer customer) {
        if(customerRepo.existsById(username)){
            customerRepo.save(customer);
            return true;
        }else{
            return false;
        }
    }

    public boolean deductBalance(String name, double amount) {
        Customer customer = customerRepo.findById(name).get();
        if (customer.getBalance() < amount) {
            return false;
        }
        customer.setBalance(customer.getBalance() - amount);
        customerRepo.save(customer);
        return true;
    }

    public Object getAllCustomers() {
        return customerRepo.findAll();
    }
}
