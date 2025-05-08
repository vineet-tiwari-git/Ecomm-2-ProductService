package com.vineet.product.services;

import java.util.List;
import com.vineet.product.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private List<Product> products = List.of(
            new Product("1", "Product 1"),
            new Product("2", "Product 2"),
            new Product("3", "Product 3"));

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

}
