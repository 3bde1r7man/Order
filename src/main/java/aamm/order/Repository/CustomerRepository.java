package aamm.order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aamm.order.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, String>{
    // void save(Customer customer);
    // Customer find(String name);
    // void delete(String name);
    // void update(Customer customer);
    // boolean exists(String name);
    // HashMap<String, Customer> findAll();
}
