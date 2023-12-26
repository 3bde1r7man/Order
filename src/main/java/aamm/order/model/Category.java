package aamm.order.model;

import java.util.List;

public class Category {
    private List<Product> products;
    private String name;
    private int count;
    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
        this.count = products.size();
    }
    public String getName() {
        return name;
    }
    public List<Product> getProducts() {
        return products;
    }
    public int getCount() {
        return count;
    }
}
