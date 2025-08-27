package com.ecom.service;
import com.ecom.entity.Category;
import com.ecom.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired private CategoryRepository categoryRepo;
    @Override
    public Category saveCategory(Category category) { return categoryRepo.save(category); }
    @Override
    public List<Category> getAllCategories() { return categoryRepo.findAll(); }
}