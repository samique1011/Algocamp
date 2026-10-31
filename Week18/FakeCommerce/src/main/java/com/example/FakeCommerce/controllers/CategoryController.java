package com.example.FakeCommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeCommerce.dtos.CreateCategoryDTO;
import com.example.FakeCommerce.schema.Category;
import com.example.FakeCommerce.services.CategoryServices;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
    public ResponseEntity<?> postMethodName(@RequestBody CreateCategoryDTO createCategoryDTO) {
        try{
            String res = categoryServices.addCategory(createCategoryDTO);
            return ResponseEntity.ok(res);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
    
    
}
