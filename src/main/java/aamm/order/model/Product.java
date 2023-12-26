package aamm.order.model;

public class Product {
    private String serialNumber;
    private String name;
    private double price;
    private String vendor;
    private String category;


    public Product( String serialNumber, String name, double price, String vendor, String category) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
        this.vendor = vendor;
        this.category = category;
    }
    
    public String getId() {
        return serialNumber;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getVendor() {
        return vendor;
    }
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product [serialNumber=" + serialNumber + ", name=" + name + ", price=" + price + ", vendor=" + vendor
                + ", category=" + category + "]";
    }
}
