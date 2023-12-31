package aamm.order.service;

import aamm.order.Validator;
import aamm.order.Repository.CustomerRepository;
import aamm.order.model.Customer;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegisterValidator implements Validator {
    @Autowired
    CustomerRepository customerRepo;


    @Override
    public boolean validate(Customer customer) {
        if(isStrongPassword(customer.getPassword()) && isEGYPhoneNum(customer.getPhone()) && isEmail(customer.getMail()) && isUniqeUsername(customer.getName())){
            customerRepo.save(customer);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isStrongPassword(String password) {
        // Password must be at least 8 characters long and contain at least one uppercase letter, 
        // one lowercase letter, one digit, and one special character.
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    public boolean isEGYPhoneNum(String phoneNum) {
        // Phone number must be 11 digits and start with 01.
        String regex = "^(01)[0125]\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }

    public boolean isEmail(String email) {
        // Email must be valid.
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }


    public boolean isUniqeUsername(String name) {
        // Username must be unique.
        if(customerRepo.exists(name)){
            return false;
        }else{
            return true;
        }
    }
}
