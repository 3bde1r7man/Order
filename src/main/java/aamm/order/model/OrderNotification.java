package aamm.order.model;

public class OrderNotification extends NotificationTemplate{
    public void setNotificationTemplate()
    {
        this.templateMessage = "Dear {X}, your order of id {y} has been {z}, Thanks for using our store :)";
    }

}
