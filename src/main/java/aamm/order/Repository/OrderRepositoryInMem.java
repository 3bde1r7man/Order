// package aamm.order.Repository;

// import java.util.HashMap;

// import org.springframework.stereotype.Repository;

// import aamm.order.model.Order;
// import aamm.order.model.Status;


// @Repository
// public class OrderRepositoryInMem {
//     HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
//     int id = 1;
//     public void add(Order order) {
//         order.setId(id++);
//         orders.put(order.getId(), order);
//     }

//     public Order getOrder(int id) {
//         return orders.get(id);
//     }

//     public void updateOrder(int id, Order order) {
//         orders.put(id, order);
//     }

//     public void deleteOrder(int id) {
//         orders.remove(id);
//     }

//     public HashMap<Integer, Order> getOrders() {
//         return orders;
//     }

//     public int changeStatus(int id, String status) {
//         Order order = orders.get(id); 
//         if (order.getStatus() == status) {
//             return -1;
//         }
//         if (order.getStatus() == Status.CANCELLED.toString() || order.getStatus() == Status.DELIVERED.toString() && (status != Status.CANCELLED.toString() && status != Status.DELIVERED.toString())) {
//             return 0;
//         }
//         order.setStatus(Status.fromString(status));
//         orders.put(id, order);
//         return 1;
//     }

//     public boolean update(Order order) {
//         if (orders.containsKey(order.getId())) {
//             orders.put(order.getId(), order);
//             return true;
//         }
//         return false;
//     }
// }