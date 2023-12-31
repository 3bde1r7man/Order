package aamm.order.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aamm.order.Repository.ProductRepository;
import aamm.order.model.Product;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    
    public boolean addProduct(Product product) {
        return productRepository.add(product);
    }


    public Product getProduct(String serialNumber) {
        return productRepository.getProduct(serialNumber);
    }

    public void updateProduct(String serialNumber, Product product) {
        productRepository.updateProduct(serialNumber, product);
    }

    public void deleteProduct(String serialNumber) {
        productRepository.deleteProduct(serialNumber);
    }

    public HashMap<String, Product> getProducts() {
        return productRepository.getProducts();
    }
}
