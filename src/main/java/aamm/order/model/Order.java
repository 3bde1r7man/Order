package aamm.order.model;

public abstract class Order {
    protected int id;
    protected String customer;
    protected double fees;
    protected Status status;

    public Order(){

    }
    
    public Order(int id, String customer, double fees, Status status) {
        this.id = id;
        this.customer = customer;
        this.fees = fees;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id){
        this.id = id;
    }
    
    public double getFees() {
        return fees;
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getStatus() {
        return status.toString();
    }
    
    public void setFees(double fees) {
        this.fees = fees;
    }
    public abstract double getTotal();

}
