package aamm.order.model;

public class ShipmentNotification extends NotificationTemplate{


    public void setNotificationTemplate() 
    {
        this.templateMessage = "Dear {X}, your order of id {y} has been {z}, Thanks for using our store :)";
    }
    public void setNotificationTemplate(String temp) 
    {
        this.templateMessage = temp;
    }
}
