package aamm.order.service;

import java.util.HashMap;

import aamm.order.Repository.ProductRepository;
import aamm.order.config.JsonUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aamm.order.model.Product;
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    
    public Object addProduct(Product product) {
        if(categoryService.isCategoryExists(product.getCategory()) == false){
            return JsonUtil.error("Category does not exist");
        }
        productRepository.save(product);
        return JsonUtil.success("Product added successfully");
    }


    public Product getProduct(String serialNumber) {
        return productRepository.findById(serialNumber).get();
    }

    public Object updateProduct(String serialNumber, Product product) {
        if(!productRepository.existsById(serialNumber)) {
            return JsonUtil.error("Product does not exist");
        }
        productRepository.save(product);
        return JsonUtil.success("Product updated successfully");
    }

    public boolean deleteProduct(String serialNumber) {
        if(!productRepository.existsById(serialNumber)) {
            return false;
        }
        productRepository.deleteById(serialNumber);
        return true;
    }

    public Object getProductsByCategory(String category) {
        return productRepository.getProductsByCategory(category);
    }
}
