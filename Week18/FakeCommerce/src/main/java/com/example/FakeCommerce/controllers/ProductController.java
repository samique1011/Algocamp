package com.example.FakeCommerce.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeCommerce.dtos.CreateProductRequestDto;
import com.example.FakeCommerce.dtos.GetFullProductDetailsReponseDTO;
import com.example.FakeCommerce.dtos.GetProductResponseDTO;
import com.example.FakeCommerce.schema.Product;
import com.example.FakeCommerce.services.ProductService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequiredArgsConstructor 
public class ProductController {
    private final ProductService productService;

    @GetMapping("/api/v1/products")
    public List<GetProductResponseDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/api/v1/products/details")
    public List<GetFullProductDetailsReponseDTO> getAllProductsWithDetails() {
        return productService.getAllProductsWithDetails();
    }
    

    
    

    @GetMapping("/api/v1/products/{id}")
    public GetProductResponseDTO getMethodName(@PathVariable Long id) {
        return productService.getProductById(id); 
    }

    @GetMapping("/api/v1/products/{id}/details")
    public GetFullProductDetailsReponseDTO getProductByIdWithDetails(@PathVariable Long id) {
        return productService.getProductDetailsById(id);
    }
    



    @PostMapping("/api/v1/products")
    public String postMethodName(@RequestBody CreateProductRequestDto body) {
        return productService.saveProduct(body);
    }

    @DeleteMapping("/api/v1/products/{id}")
    public String deleteMethodName(@PathVariable Long id){
        return productService.deleteProduct(id);
    }

    @GetMapping("/api/v1/products/search")
    public List<Product> getMethodName(@RequestParam("categoryName") String category) {
        return productService.getResultByCategory(category);
    }

    @GetMapping("/api/v1/products/category")
    public List<Object[]> getMethodName() {
        return productService.getUniqueCategoryProducts();
    }
    
    
        
    
    
    
    
}
