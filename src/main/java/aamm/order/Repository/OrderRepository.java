package aamm.order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aamm.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{
    // void add(Order order);
    // Order getOrder(int id);
    // void updateOrder(int id, Order order);
    // void deleteOrder(int id);
    // int changeStatus(int id, String status);
    // boolean update(Order order);
    // HashMap<Integer, Order> getOrders();
}
