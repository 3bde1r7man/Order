package aamm.order.model;

public class ShipmentNotification {
    String shipmentMessage;

    public ShipmentNotification()
    {
        this.shipmentMessage="Dear {X}, your order of id {y} has been {z}, Thanks for using our store :)";
    }
    
    public String getShipmentMessage()
    {
        return shipmentMessage;
    }
}
