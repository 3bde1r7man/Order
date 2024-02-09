package aamm.order.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aamm.order.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, String>{
    // Object add(Category category);
    // Category getCategory(String slug);
    // boolean updateCategory(String slug, Category category);
    // boolean deleteCategory(String slug);
    // HashMap<String, Product> getProducts(String categoryName);
    // HashMap<String, Category> getCategories();
    // static boolean isCategoryExists(String slug){return false;}
}
