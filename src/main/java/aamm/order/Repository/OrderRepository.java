package aamm.order.Repository;

import java.util.HashMap;

import aamm.order.model.Order;

public interface OrderRepository {
    void add(Order order);
    Order getOrder(int id);
    void updateOrder(int id, Order order);
    void deleteOrder(int id);
    int changeStatus(int id, String status);
    boolean update(Order order);
    HashMap<Integer, Order> getOrders();
}
