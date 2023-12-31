package aamm.order.model;

public enum ContactType {
    EMAIL, SMS;

    @Override
    public String toString() {
        switch (this) {
            case EMAIL:
                return "Email";
            case SMS:
                return "SMS";
            default:
                return "Unknown";
        }
    }

    public static ContactType fromString(String status) {
        switch (status) {
            case "Email":
                return EMAIL;
            case "SMS":
                return SMS;
            default:
                return null;
        }
    }
}
