package com.example.FakeCommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.FakeCommerce.dtos.CreateProductRequestDto;
import com.example.FakeCommerce.dtos.GetFullProductDetailsReponseDTO;
import com.example.FakeCommerce.dtos.GetProductResponseDTO;
import com.example.FakeCommerce.repositories.CategoryRepository;
import com.example.FakeCommerce.repositories.ProductRepository;
import com.example.FakeCommerce.schema.Category;
import com.example.FakeCommerce.schema.Product;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service 
@RequiredArgsConstructor 
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public List<GetProductResponseDTO> getAllProducts(){
        List <Product> allProducts = productRepository.findAll();
        List <GetProductResponseDTO> response = new ArrayList<>();
        for (Product product : allProducts) {
            GetProductResponseDTO cpd = GetProductResponseDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .image(product.getImage())
            .ratings(product.getRatings())
            .build();

            response.add(cpd);
        }

        return response;
    }

    public List<GetFullProductDetailsReponseDTO> getAllProductsWithDetails(){
        List <Product> allProducts = productRepository.getCompleteProductDetails();
        List<GetFullProductDetailsReponseDTO> response = new ArrayList<>();
        for(Product p : allProducts){
            GetFullProductDetailsReponseDTO res = GetFullProductDetailsReponseDTO.builder()
            .id(p.getId())
            .name(p.getName())
            .description(p.getDescription())
            .image(p.getImage())
            .ratings(p.getRatings())
            .categoryId(p.getCategory().getId())
            .categoryName(p.getCategory().getName())
            .build();

            response.add(res);

        }

        return response;
    }

    public GetFullProductDetailsReponseDTO getProductDetailsById(Long id) throws RuntimeException{


        Product p = productRepository.getCompleteProductDetailsWithId(id).get(0);
        return GetFullProductDetailsReponseDTO.builder()
        .id(p.getId())
        .name(p.getName())
        .description(p.getDescription())
        .image(p.getImage())
        .ratings(p.getRatings())
        .categoryId(p.getCategory().getId())
        .categoryName(p.getCategory().getName())
        .build();
    }

    public GetProductResponseDTO getProductById(Long id)throws RuntimeException{
        return productRepository.findById(id).map(product -> GetProductResponseDTO.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .image(product.getImage())
            .ratings(product.getRatings())
            .build())
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND ,
            "Such Product doesn't exist"
        ));
    }

    

    public String saveProduct(CreateProductRequestDto p){
        try{

            Category c = categoryRepository.findById(p.getCategoryId()).orElseThrow(() -> new RuntimeException("Such cateogry doesnt exists"));
            Product newProduct = Product.builder().name(p.getName())
            .description(p.getDescription()).image(p.getImage())
            .category(c)
            .ratings(p.getRatings()).build();

            productRepository.save(newProduct);
            return "Product saved";

        }catch (Exception e) {
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
