package aamm.order.model;

public class ShipmentNotification extends NotificationTemplate{
    public void setNotificationTemplate() 
    {
        this.templateMessage = "Dear {x}, your order of id {y} has been {z}, Thanks for using our store :)";
    }
}
