package aamm.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.model.Product;
import aamm.order.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;
    
    @PostMapping("/add")
    public boolean addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PostMapping("/update")
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product.getSerialNumber(), product);
    }


    @PostMapping("/delete/{serialNumber}")
    public void deleteProduct(@PathVariable String serialNumber) {
        productService.deleteProduct(serialNumber);
    }

    @PostMapping("/get/{serialNumber}")
    public Product getProduct(@PathVariable String serialNumber) {
        return productService.getProduct(serialNumber);
    }

    @PostMapping("/getall")
    public void getProducts() {
        productService.getProducts();
    }

}
