package aamm.order.model;

import java.util.List;

public class Category {
    private List<String> products;
    private String slug;
    private int count;
    
    public Category(String slug, List<String> products) {
        this.slug = slug;
        this.products = products;
        this.count = products.size();
    }

    public String getSlug() {
        return slug;
    }
    
    public List<String> getProducts() {
        return products;
    }
    
    public int getCount() {
        return count;
    }
}
