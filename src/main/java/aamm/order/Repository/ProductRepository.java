package aamm.order.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import aamm.order.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, String>{
    // int add(Product product);
    // Product getProduct(String serialNumber);
    // int updateProduct(String serialNumber, Product product);
    // boolean deleteProduct(String serialNumber);
    // HashMap<String, Product> getProducts();
    public List<Product> getProductsByCategory(String categoryName);
}
