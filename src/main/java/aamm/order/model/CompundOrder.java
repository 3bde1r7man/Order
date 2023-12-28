package aamm.order.model;

import java.util.List;




public class CompundOrder extends Order {
    List<SimpleOrder> orders;
    
    
    // @Override
    // public void placeOrder(Order order) {
    //     CompundOrder compundOrder = (CompundOrder) order;
    //     for (Order o : compundOrder.orders) {
    //         o.placeOrder(o);
    //     }
    // }

    public CompundOrder(List<SimpleOrder> orders, Status status, int id, String customer, double fees) {
        this.id = id;
        this.customer = customer;
        this.fees = fees;
        this.orders = orders;
        this.status = status;
    }

    public List<SimpleOrder> getOrders() {
        return orders;
    }


    @Override
    public double getTotal() {
        double total = 0;
        for (Order o : orders) {
            total += o.getTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        return "CompundOrder [orders=" + orders.toString() + ", status=" + status +  ", id= " + id + ", customer=" + customer + ", fees=" + fees + "]";
    }
}
