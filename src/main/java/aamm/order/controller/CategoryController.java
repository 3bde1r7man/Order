package aamm.order.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.model.Category;
import aamm.order.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    public boolean addCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @PostMapping("/update")
    public void updateCategory(@RequestBody Category category) {
        categoryService.updateCategory(category.getSlug(), category);
    }

    @PostMapping("/delete")
    public void deleteCategory(@RequestBody String slug) {
        categoryService.deleteCategory(slug);
    }

    @PostMapping("/get/{slug}")
    public Category getCategory(@PathVariable String slug) {
        return categoryService.getCategory(slug);
    }

    @PostMapping("/getall")
    public HashMap<String, Category> getCategories() {
        return categoryService.getCategories();
    }
}
