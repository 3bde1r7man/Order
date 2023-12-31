package aamm.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aamm.order.config.JsonUtil;
import aamm.order.model.Product;
import aamm.order.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    ProductService productService;
    
    @PostMapping("")
    public Object addProduct(@RequestBody Product product) {
        int response = productService.addProduct(product);
        if(response == -1){
            return JsonUtil.error("Product already exists");
        } else if( response == 0){
            return JsonUtil.error("Category does not exist");
        } else{
            return JsonUtil.success("Product added successfully");
        }
    }

    @PutMapping("/{serialNumber}")
    public Object updateProduct(@PathVariable String serialNumber, @RequestBody Product product) {
        int response = productService.updateProduct(serialNumber, product);
        if(response == -1){
            return JsonUtil.error("Product already exists");
        } else if( response == 0){
            return JsonUtil.error("Category does not exist");
        } else{
            return JsonUtil.success("Product added successfully");
        }
    }


    @DeleteMapping("/{serialNumber}")
    public Object deleteProduct(@PathVariable String serialNumber) {
        if (productService.deleteProduct(serialNumber)) {
            return JsonUtil.success("Product deleted successfully");
        } else {
            return JsonUtil.error("Product does not exist");
        }
    }

    @GetMapping("/{serialNumber}")
    public Object getProduct(@PathVariable String serialNumber) {
        Object response = productService.getProduct(serialNumber);
        if (response != null) {
            return response;
        } else {
            return JsonUtil.error("Product does not exist");
        }
    }

    @GetMapping("")
    public Object getProducts() {
        Object response = productService.getProducts();
        if (response != null) {
            return response;
        } else {
            return JsonUtil.error("No products found");
        }
    }

}
