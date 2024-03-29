package aamm.order.Repository;



import java.util.HashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import aamm.order.model.Customer;

@Repository
@Primary
public class CustomerRepositoryInMem implements CustomerRepository {
    private static HashMap<String, Customer> customers = new HashMap<String, Customer>();
    long id = 1;

    public void save(Customer customer) {
        customer.setId(id++);
        customers.put(customer.getName(), customer);
    }

    public Customer find(String name) {
        return customers.get(name);
    }

    public void delete(String name) {
        customers.remove(name);
    }

    public void update(Customer customer) {
        customers.put(customer.getName(), customer);
    }

    public HashMap<String, Customer> findAll() {
        if (customers.isEmpty()) {
            return null;
        }
        return customers;
    }

    public boolean exists(String name) {
        return customers.containsKey(name);
    }
}

