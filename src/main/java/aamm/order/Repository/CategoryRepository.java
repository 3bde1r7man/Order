package aamm.order.Repository;

import java.util.HashMap;

import aamm.order.model.Category;
import aamm.order.model.Product;

public interface CategoryRepository {
    Object add(Category category);
    Category getCategory(String slug);
    boolean updateCategory(String slug, Category category);
    boolean deleteCategory(String slug);
    HashMap<String, Product> getProducts(String categoryName);
    HashMap<String, Category> getCategories();
    static boolean isCategoryExists(String slug){return false;}
}
