package aamm.order.Repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import aamm.order.model.Product;
@Repository
public class ProductRepository {

    HashMap<String, Product> products = new HashMap<String, Product>();

    public boolean add(Product product) {
        if(products.containsKey(product.getSerialNumber())) {
            return false;
        }
        products.put(product.getSerialNumber(), product);
        return true;
    }

    public Product getProduct(String serialNumber) {
        return products.get(serialNumber);
    }

    public List<Product> getCategoryProducts(String categoryName){
        List<Product> p = new ArrayList<>();
        for(Product product : products.values()){
            if(product.getCategory().equals(categoryName)){
                p.add(product);
            }
        }
        return p;
    }

    public void updateProduct(String serialNumber, Product product) {
        products.put(serialNumber, product);
    }

    public void deleteProduct(String serialNumber) {
        products.remove(serialNumber);
    }

    public HashMap<String, Product> getProducts() {
        return products;
    }
}
