package aamm.order.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.model.Product;
@Service
public class ProductService {
    @Autowired
    ProductService productService;
    
    public boolean addProduct(Product product) {
        return productService.addProduct(product);
    }


    public Product getProduct(String serialNumber) {
        return productService.getProduct(serialNumber);
    }

    public void updateProduct(String serialNumber, Product product) {
        productService.updateProduct(serialNumber, product);
    }

    public void deleteProduct(String serialNumber) {
        productService.deleteProduct(serialNumber);
    }

    public HashMap<String, Product> getProducts() {
        return productService.getProducts();
    }
}
