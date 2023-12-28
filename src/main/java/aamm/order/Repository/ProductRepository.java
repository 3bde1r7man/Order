package aamm.order.Repository;


import java.util.HashMap;

import aamm.order.model.Product;

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
