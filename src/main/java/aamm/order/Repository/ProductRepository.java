package aamm.order.Repository;


import aamm.order.config.JsonUtil;
import aamm.order.model.Product;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

@Repository
public class ProductRepository {

    static HashMap<String, Product> products = new HashMap<String, Product>();

    public int add(Product product) {
        if(products.containsKey(product.getSerialNumber())) {
            return -1;
        }

        if(!CategoryRepository.isCategoryExists(product.getCategory())) {
            return 0;
        }

        products.put(product.getSerialNumber(), product);
        return 1;
    }

    public Product getProduct(String serialNumber) {
        return products.get(serialNumber);
    }

    public static HashMap<String, Product> getCategoryProducts(String category) {
        HashMap<String, Product> categoryProducts = new HashMap<String, Product>();
        for(Product product : products.values()) {
            if(product.getCategory().equals(category)) {
                categoryProducts.put(product.getSerialNumber(), product);
            }
        }
        return categoryProducts;
    }

    public int updateProduct(String serialNumber, Product product) {
        if(!products.containsKey(serialNumber)) {
            return -1;
        }

        if(!CategoryRepository.isCategoryExists(product.getCategory())) {
            return 0;
        }

        products.put(serialNumber, product);
        return 1;
    }

    public boolean deleteProduct(String serialNumber) {
        if(!products.containsKey(serialNumber)) {
            return false;
        }
        products.remove(serialNumber);
        return true;
    }

    public HashMap<String, Product> getProducts() {
        if (products.size() == 0) {
            return null;
        }
        return products;
    }
}
