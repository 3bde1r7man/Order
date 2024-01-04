package aamm.order.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.config.JsonUtil;
import aamm.order.model.Category;
import aamm.order.service.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("")
    public Object addCategory(@RequestBody Category category) {
        if (categoryService.addCategory(category)) {
            return JsonUtil.success("Category added successfully");
        } else {
            return JsonUtil.error("Category already exists");
        }
    }

    @PutMapping("/{slug}")
    public Object updateCategory(@PathVariable String slug, @RequestBody Category category) {
        if (categoryService.updateCategory(slug, category)) {
            return JsonUtil.success("Category updated successfully");
        } else {
            return JsonUtil.error("Category does not exists");
        }
    }

    @DeleteMapping("/{slug}")
    public Object deleteCategory(@PathVariable String slug) {
        if (categoryService.deleteCategory(slug)) {
            return JsonUtil.success("Category deleted successfully");
        } else {
            return JsonUtil.error("Category does not exists");
        }
    }

    @GetMapping("/{slug}")
    public Object getCategory(@PathVariable String slug) {
        if (categoryService.getCategory(slug) != null) {
            return categoryService.getCategory(slug);
        } else {
            return JsonUtil.error("Category does not exist");
        }
    }

    @GetMapping("")
    public Object getCategories() {
        if (categoryService.getCategories() != null) {
            return categoryService.getCategories();
        } else {
            return JsonUtil.error("No categories found");
        }
    }

    @GetMapping("/{slug}/products")
    public Object getCategoryProducts(@PathVariable String slug) {
        if (categoryService.getCategoryProducts(slug) != null) {
            return categoryService.getCategoryProducts(slug);
        } else {
            return JsonUtil.error("No products found");
        }
    }
}
