package aamm.order.model;

import java.util.HashMap;
import java.util.List;

import aamm.order.Repository.ProductRepository;
public class Category {
    private String slug;
    private int count;
    public Category(String slug, List<String> products) {
        this.slug = slug;
        this.count = getProducts().size();
    }
    public String getSlug() {
        return slug;
    }

    public HashMap<String, Product> getProducts() {
        return ProductRepository.getCategoryProducts(slug);
    }

    public int getCount() {
        return count;
    }
}
