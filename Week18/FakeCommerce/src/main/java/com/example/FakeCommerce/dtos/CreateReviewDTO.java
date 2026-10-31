package com.example.FakeCommerce.dtos;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data 
@AllArgsConstructor 
@Builder 

public class CreateReviewDTO {
    private Long productId;
    private Long orderId;
    private BigDecimal ratings;
    private String reviewDescription;
}
