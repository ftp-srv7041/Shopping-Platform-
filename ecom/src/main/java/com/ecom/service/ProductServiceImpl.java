package com.ecom.service;

import com.ecom.entity.Product;
import com.ecom.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service // Yeh annotation batati hai ki yeh ek service bean hai
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product saveProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product getProductById(String id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProduct(String id) {
        productRepo.deleteById(id);
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        // Yeh method repository me add karna padega
        // return productRepo.findByCategory(category);
        return null; // Abhi ke liye isko null rakhte hain
    }
}
