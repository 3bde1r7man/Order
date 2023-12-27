package aamm.order.model;




public abstract class Order {
    
    protected long id;
    protected String customer;
    protected double fees;
    

    public long getId() {
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
