package aamm.order.Repository;

import java.util.HashMap;


import aamm.order.model.Customer;

public interface CustomerRepository {
    void save(Customer customer);
    Customer find(String name);
    void delete(String name);
    void update(Customer customer);
    boolean exists(String name);
    HashMap<String, Customer> findAll();
}
