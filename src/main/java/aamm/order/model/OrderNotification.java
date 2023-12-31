package aamm.order.model;

public class OrderNotification extends NotificationTemplate{
    
    String orderMessage;

    public String setNotificationTemplate()
    {
        this.orderMessage="Dear {x}, your order of the item {y} has been confirmed, Thanks for using our store :)";
        return this.orderMessage;
    }

    public String getMessage()
    {
        return this.orderMessage;
    }
}
