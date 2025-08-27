package com.ecom.service;
import com.ecom.entity.Category;
import java.util.List;
public interface CategoryService {
    Category saveCategory(Category category);
    List<Category> getAllCategories();
}