package aamm.order.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.CategoryRepository;
import aamm.order.model.Category;
import aamm.order.model.Product;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public boolean addCategory(Category category) {
        if (CategoryRepository.isCategoryExists(category.getSlug())) {
            return false;
        }
        categoryRepository.add(category);
        return true;
    }

    public Category getCategory(String slug) {
        if (CategoryRepository.isCategoryExists(slug)) {
            return categoryRepository.getCategory(slug);
        } else {
            return null;
        }
    }

    public boolean updateCategory(String slug, Category category) {
        if (CategoryRepository.isCategoryExists(slug)) {
            categoryRepository.updateCategory(slug, category);
            return true;
        } else {
            return false;
        } 
    }

    public boolean deleteCategory(String slug) {
        if (CategoryRepository.isCategoryExists(slug)) {
            categoryRepository.deleteCategory(slug);
            return true;
        } else {
            return false;
        }
    }

    public HashMap<String, Category> getCategories() {
        if (categoryRepository.getCategories() != null) {
            return categoryRepository.getCategories();
        } else {
            return null;
        }
    }

    public HashMap<String, Product> getCategoryProducts(String slug) {
        if (CategoryRepository.isCategoryExists(slug)) {
            return categoryRepository.getProducts(slug);
        } else {
            return null;
        }
    }

}