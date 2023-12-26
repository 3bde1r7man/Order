package aamm.order;
import aamm.order.model.Customer;
import aamm.order.model.Order;
import aamm.order.model.Product;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

@Repository
public class InMemDB implements DB {

    // first CustomerName , second the Customer object
    private static HashMap<String, Customer> customers = new HashMap<String, Customer>();
    private static HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
    private static HashMap<String, Product> products = new HashMap<String, Product>();

    @Override
    public void connect() {
        System.out.println("Connecting to InMemDB...");
    }
    @Override
    public void add(Customer customer) {
        customers.put(customer.getName(), customer);
    }
    @Override
    public boolean exists(String name) {
        return customers.containsKey(name);
    }
    @Override
    public Customer getCustomer(String name) {
        return customers.get(name);
    }
    @Override
    public void add(Order order) {
        
        orders.put(order.getId(), order);
    }
    @Override
    public Order getOrder(int id) {
        return orders.get(id);
    }
    @Override
    public void add(Product product) {
        products.put(product.getId(), product);
    }
    @Override
    public Product getProduct(String id) {
        return products.get(id);
    }

}
