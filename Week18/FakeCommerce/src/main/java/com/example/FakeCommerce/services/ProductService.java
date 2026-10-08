package com.example.FakeCommerce.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.FakeCommerce.dtos.CreateProductRequestDto;
import com.example.FakeCommerce.repositories.ProductRepository;
import com.example.FakeCommerce.schema.Product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id)throws RuntimeException{
        return productRepository.findById(id).
        orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND ,
            "Such Product doesn't exist"
        ));
    }

    public String saveProduct(CreateProductRequestDto p){
        Product newProduct = Product.builder().name(p.getName())
        .description(p.getDescription()).image(p.getImage())
        .category(p.getCategory()).ratings(p.getRatings()).build();
        try {
            productRepository.save(newProduct);
            return "Product saved";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Transactional 
    public String deleteProduct(Long id){
        if(productRepository.existsById(id)){
            productRepository.deleteById(id);
            return "Item successfully deleted";
        }
        else    return "No such Item exists";

    }

    public List<Product> getResultByCategory(String category){
        return productRepository.findByCategory(category);
    }

    public List<Object[]> getUniqueCategoryProducts(){
        return productRepository.getUniqueCategory();
    }

}
