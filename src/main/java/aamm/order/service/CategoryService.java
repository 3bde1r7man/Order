package aamm.order.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.CategoryRepository;
import aamm.order.model.Category;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public boolean addCategory(Category category) {
        return categoryRepository.add(category);
    }

    public Category getCategory(String slug) {
        return categoryRepository.getCategory(slug);
    }

    public void updateCategory(String slug, Category category) {
        categoryRepository.updateCategory(slug, category);
    }

    public void deleteCategory(String slug) {
        categoryRepository.deleteCategory(slug);
    }

    public HashMap<String, Category> getCategories() {
        return categoryRepository.getCategories();
    }

}