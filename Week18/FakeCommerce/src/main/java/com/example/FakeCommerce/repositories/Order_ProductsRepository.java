package com.example.FakeCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FakeCommerce.schema.OrderProducts;

public interface  Order_ProductsRepository extends JpaRepository<OrderProducts , Long> {
    
}
