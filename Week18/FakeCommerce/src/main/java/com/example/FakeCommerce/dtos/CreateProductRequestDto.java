package com.example.FakeCommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@Data 
@NoArgsConstructor 
@Builder 
public class CreateProductRequestDto {
    
    
    private String name;
    private String description ;
    private String image;
    private String category ;
    private String ratings;
}
