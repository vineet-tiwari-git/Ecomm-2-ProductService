package com.vineet.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.vineet.product.services.ProductService;
import com.vineet.product.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id) {
        Product product = productService.getProductById(id);
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("Product: " + product);
        System.out.println("----------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------");
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }
}
