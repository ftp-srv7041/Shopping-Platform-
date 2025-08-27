package com.ecom.repository;
import com.ecom.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface CategoryRepository extends MongoRepository<Category, String> {
}