package aamm.order.model;

public class OrderNotification {
    
    String orderMessage;
    
    public OrderNotification()
    {
        this.orderMessage="Dear {x}, your order of the item {y} has been confirmed, Thanks for using our store :)";
    }

    public String getOrderMessage()
    {
        return orderMessage;
    }
}
