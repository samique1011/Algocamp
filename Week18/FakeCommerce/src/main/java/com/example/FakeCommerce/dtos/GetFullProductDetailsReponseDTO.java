package com.example.FakeCommerce.dtos;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
 
@Getter 
@Setter 
@SuperBuilder 
public class GetFullProductDetailsReponseDTO extends GetProductResponseDTO {
    private Long categoryId;
    private String categoryName;
}
