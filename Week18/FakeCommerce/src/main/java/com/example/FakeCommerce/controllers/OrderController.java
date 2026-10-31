package com.example.FakeCommerce.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FakeCommerce.dtos.CreateOrderRequestDTO;
import com.example.FakeCommerce.dtos.GetOrderResponseDTO;
import com.example.FakeCommerce.services.OrderServices;

import lombok.AllArgsConstructor;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController 
@RequestMapping ("api/v1/orders")
@AllArgsConstructor 
public class OrderController {
    private final OrderServices orderServices;

    @GetMapping("")
    public ResponseEntity<?> getAllOrders() {
        try{
            List<GetOrderResponseDTO> li = orderServices.getAllOrders();
            return ResponseEntity.ok(li);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequestDTO createOrderRequestDTO) {
        try{
            String res = orderServices.createOrder(createOrderRequestDTO);
            return ResponseEntity.ok(res);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}
