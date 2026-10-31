package com.example.FakeCommerce.dtos;

import com.example.FakeCommerce.schema.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class OrderItems {
    private Long productId;
    private OrderStatus orderStatus;
    private Integer quantity;
}
