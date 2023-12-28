package aamm.order.model;

import java.util.List;

public class Category {
    private List<Product> products;
    private String slug;
    private int count;
    public Category(String slug, List<Product> products) {
        this.slug = slug;
        this.products = products;
        this.count = products.size();
    }
    public String getSlug() {
        return slug;
    }
    public List<Product> getProducts() {
        return products;
    }
    public int getCount() {
        return count;
    }
}
