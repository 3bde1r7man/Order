package aamm.order.service;


import aamm.order.model.Order;

public interface OrderService {
    public boolean placeOrder(Order order);
    public boolean cancelOrder(int id);
    public Order getOrder(int id);
}
