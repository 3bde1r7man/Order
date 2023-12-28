package aamm.order.Repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import aamm.order.model.Order;
import aamm.order.model.Status;


@Repository
public class OrderRepository {
    HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
    int id = 1;
    public void add(Order order) {
        order.setId(id++);
        orders.put(order.getId(), order);
    }

    public Order getOrder(int id) {
        return orders.get(id);
    }

    public void updateOrder(int id, Order order) {
        orders.put(id, order);
    }

    public void deleteOrder(int id) {
        orders.remove(id);
    }

    public HashMap<Integer, Order> getOrders() {
        return orders;
    }

    public void changeStatus(int id, String status) {
        Order order = orders.get(id); 
        order.setStatus(Status.fromString(status));
        orders.put(id, order);
    }

    public void update(Order order) {
        orders.put(order.getId(), order);
    }
}