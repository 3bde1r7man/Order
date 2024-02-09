package aamm.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.CategoryRepository;
import aamm.order.model.Category;


@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductService productService;

    public boolean isCategoryExists(String slug) {
        return categoryRepository.existsById(slug);
    }
    
    public boolean addCategory(Category category) {
        if (categoryRepository.existsById(category.getSlug())) {
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    public Category getCategory(String slug) {
        if (categoryRepository.existsById(slug)) {
            return categoryRepository.findById(slug).get();
        } else {
            return null;
        }
    }

    public boolean updateCategory(String slug, Category category) {
        if (categoryRepository.existsById(slug)) {
            categoryRepository.save(category);
            return true;
        } else {
            return false;
        } 
    }

    public boolean deleteCategory(String slug) {
        if (categoryRepository.existsById(slug)) {
            categoryRepository.deleteById(slug);
            return true;
        } else {
            return false;
        }
    }

    public Object getCategories() {
        if (categoryRepository.findAll() != null) {
            return categoryRepository.findAll();
        } else {
            return null;
        }
    }

    public Object getCategoryProducts(String slug) {
        if (categoryRepository.existsById(slug)) {
            return productService.getProductsByCategory(slug);
        } else {
            return null;
        }
    }

}