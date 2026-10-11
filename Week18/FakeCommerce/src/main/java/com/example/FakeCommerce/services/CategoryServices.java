package com.example.FakeCommerce.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.FakeCommerce.dtos.CreateCategoryDTO;
import com.example.FakeCommerce.repositories.CategoryRepository;
import com.example.FakeCommerce.schema.Category;

import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class CategoryServices {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public String addCategory(CreateCategoryDTO createCategoryDTO){
        Category c = Category.builder().name(createCategoryDTO.getName()).build();
        try{
            categoryRepository.save(c);
            return "Category Saved";
        }catch(Exception e){
            return e.getMessage();
        }
    }

    public Category getCategoryById(Long id)throws RuntimeException {
        return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException());
    }

}
