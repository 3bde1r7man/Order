package aamm.order.model;

public enum Status {
    CONFIRMED, CANCELLED, SHIPPED, DELIVERED;

    @Override
    public String toString() {
        switch (this) {
            case CONFIRMED:
                return "Confirmed";
            case CANCELLED:
                return "Cancelled";
            case SHIPPED:
                return "Shipped";
            case DELIVERED:
                return "Delivered";
            default:
                return "Unknown";
        }
    }

    public static Status fromString(String status) {
        switch (status) {
            case "Confirmed":
                return CONFIRMED;
            case "Cancelled":
                return CANCELLED;
            case "Shipped":
                return SHIPPED;
            case "Delivered":
                return DELIVERED;
            default:
                return null;
        }
    }
}
