package aamm.order.service;

import java.util.HashMap;

import aamm.order.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import aamm.order.model.Product;
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    
    public int addProduct(Product product) {
        return productRepository.add(product);
    }


    public Product getProduct(String serialNumber) {
        return productRepository.getProduct(serialNumber);
    }

    public int updateProduct(String serialNumber, Product product) {
        return productRepository.updateProduct(serialNumber, product);
    }

    public boolean deleteProduct(String serialNumber) {
        return productRepository.deleteProduct(serialNumber);
    }

    public HashMap<String, Product> getProducts() {
        return productRepository.getProducts();
    }
}
