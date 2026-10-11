package com.example.FakeCommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeCommerce.dtos.CreateCategoryDTO;
import com.example.FakeCommerce.schema.Category;
import com.example.FakeCommerce.services.CategoryServices;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping("api/v1/category")
@AllArgsConstructor 

public class CategoryController {
    
    private final CategoryServices categoryServices;
    @GetMapping("")
    public List<Category> getMethodName() {
        return categoryServices.getAllCategories();
    }

    @PostMapping("")
    public String postMethodName(@RequestBody CreateCategoryDTO createCategoryDTO) {
        return categoryServices.addCategory(createCategoryDTO);
    }
    
    
}
