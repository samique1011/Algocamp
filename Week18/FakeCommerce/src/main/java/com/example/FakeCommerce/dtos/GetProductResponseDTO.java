package com.example.FakeCommerce.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@SuperBuilder 
public class GetProductResponseDTO {
    private Long id;
    private String name;
    private String description ;
    private String image;
    private String ratings;
}
