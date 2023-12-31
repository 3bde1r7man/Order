package aamm.order.Repository;

import java.util.HashMap;

import aamm.order.model.Product;

public interface ProductRepository {
    int add(Product product);
    Product getProduct(String serialNumber);
    int updateProduct(String serialNumber, Product product);
    boolean deleteProduct(String serialNumber);
    HashMap<String, Product> getProducts();
}
