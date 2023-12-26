package aamm.order.model;


public abstract class Order {
    protected int id;
    protected String customer;
    protected double fees;
    

    public int getId() {
        return id;
    }
    

    public double getFees() {
        return fees;
    }
    public String getCustomer() {
        return customer;
    }
    
    public abstract void placeOrder(Order order);
    public abstract double getTotal();

}
