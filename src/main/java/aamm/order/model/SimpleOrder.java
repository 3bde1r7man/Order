package aamm.order.model;

import java.util.List;


public class SimpleOrder extends Order {

    private List<Product> products;
    private double totalPrice;
    

    public SimpleOrder( List<Product> products, double totalPrice, Status status, int id, String customer, double fees) {
        this.id = id;
        this.customer = customer;
        this.fees = fees;
        this.products = products;
        this.totalPrice = totalPrice;
        this.status = status;
    }
    
    // @Override
    // public void placeOrder(Order order) {
    //     // do nothing
    // }

    @Override
    public double getTotal() {
        return totalPrice + fees;
    }


    public List<Product> getProducts() {
        return products;
    }
    
    @Override
    public String toString() {
        return "SimpleOrder [products=" + products.toString() + ", totalPrice=" + totalPrice + ", status=" + status +  " id= " + id + ", customer=" + customer + ", fees=" + fees + "]";
    }

}
