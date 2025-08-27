package com.ecom.service;

import com.ecom.entity.Product;
import java.util.List;

public interface ProductService {
    Product saveProduct(Product product);
    List<Product> getAllProducts();

    // Yahan Integer ko String se badal diya hai
    Product getProductById(String id);

    // Yahan bhi Integer ko String se badal diya hai
    void deleteProduct(String id);

    List<Product> getProductsByCategory(String category);
}
