package com.example.FakeCommerce.dtos;

import com.example.FakeCommerce.schema.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data 
@Builder 
@AllArgsConstructor 
public class GetOrderResponseDTO {
    private Long id;
    private Long productId;
    private String productName;
    private Long orderId;
    private OrderStatus orderStatus;
    private Integer quantity;
}
