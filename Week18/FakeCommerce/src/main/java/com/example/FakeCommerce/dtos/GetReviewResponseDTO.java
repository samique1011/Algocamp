package com.example.FakeCommerce.dtos;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data 
@AllArgsConstructor 
@Builder 
public class GetReviewResponseDTO {
    private Long id;
    private Long productId;
    private Long orderId;
    private String productName;
    private BigDecimal ratings;
    private LocalDateTime createdAt;
    private String reviewDescription;
}
