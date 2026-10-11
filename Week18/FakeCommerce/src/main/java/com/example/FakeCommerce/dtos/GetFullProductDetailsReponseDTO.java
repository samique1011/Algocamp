package com.example.FakeCommerce.dtos;

import java.util.Locale.Category;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Data 
@Getter 
@Setter 
@SuperBuilder 
public class GetFullProductDetailsReponseDTO extends GetProductResponseDTO {
    private Long categoryId;
    private String categoryName;
}
