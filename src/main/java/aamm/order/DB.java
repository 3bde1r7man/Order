package aamm.order;

import aamm.order.model.Customer;
import aamm.order.model.Order;
import aamm.order.model.Product;

public interface DB{
    public void connect();
    public void add(Customer customer);
    public boolean exists(String name);
    public Customer getCustomer(String name);
    public void add(Order order);
    public Order getOrder(int id);
    public void add(Product product);
    public Product getProduct(String id);
}
