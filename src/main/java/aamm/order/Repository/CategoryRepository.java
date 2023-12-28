package aamm.order.Repository;

import java.util.HashMap;

import aamm.order.model.Category;

public class CategoryRepository {
    HashMap<String, Category> categories = new HashMap<String, Category>();

    public boolean add(Category category) {
        if(categories.containsKey(category.getSlug())) {
            return false;
        }
        categories.put(category.getSlug(), category);
        return true;
    }

    public Category getCategory(String slug) {
        return categories.get(slug);
    }

    public void updateCategory(String slug, Category category) {
        categories.put(slug, category);
    }

    public void deleteCategory(String slug) {
        categories.remove(slug);
    }

    // public List<Product> getProducts(String categoryName){
    //     return categories.get(categoryName).getProducts();
    // }


    public HashMap<String, Category> getCategories() {
        return categories;
    }
}
