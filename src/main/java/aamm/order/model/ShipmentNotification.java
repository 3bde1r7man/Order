package aamm.order.model;

public class ShipmentNotification extends NotificationTemplate{

    String shipmentMessage;

    public String setNotificationTemplate() {
        this.shipmentMessage="Dear {X}, your order of id {y} has been {z}, Thanks for using our store :)";
        return this.shipmentMessage;
    }

    public String getMessage()
    {
        return this.shipmentMessage;
    }
}
