// package aamm.order.service;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import aamm.order.Repository.DB;
// import aamm.order.model.Order;
// import aamm.order.model.SimpleOrder;
// import aamm.order.model.Status;
// @Service
// public class SimpleOrderService {
//     @Autowired
//     private DB DB;
    
//     public void placeOrder(SimpleOrder order) {
//         order.setStatus(Status.CONFIRMED);
//         DB.add(order);
//     }
//     public Order getOrder(int id) {
//         return DB.getOrder(id);
//     }
// }
