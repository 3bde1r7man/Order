// package aamm.order.Repository;

// import org.springframework.stereotype.Repository;
// import aamm.order.config.JsonUtil;
// import aamm.order.model.Category;
// import aamm.order.model.Product;
// import java.util.HashMap;

// @Repository
// public class CategoryRepositoryInMem {
//     static HashMap<String, Category> categories = new HashMap<String, Category>();

//     public Object add(Category category) {
//         if(categories.containsKey(category.getSlug())) {
//             return JsonUtil.error("Category already exists");
//         }
//         categories.put(category.getSlug(), category);
//         return JsonUtil.success("Category added successfully");
//     }

//     public Category getCategory(String slug) {
//         return categories.get(slug);
//     }

//     public boolean updateCategory(String slug, Category category) {
//         if (!categories.containsKey(slug)) {
//             return false;
//         }
//         categories.put(slug, category);
//         return true;
//     }

//     public boolean deleteCategory(String slug) {
//         if (!categories.containsKey(slug)) {
//             return false;
//         }
//         categories.remove(slug);
//         return true;
//     }

//     public HashMap<String, Product> getProducts(String categoryName){
//         return categories.get(categoryName).getProducts();
//     }


//     public HashMap<String, Category> getCategories() {
//         return categories;
//     }

//     public static boolean isCategoryExists(String slug) {
//         return categories.containsKey(slug);
//     }
// }
