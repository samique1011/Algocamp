package com.example.FakeCommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FakeCommerce.schema.Orders;

public interface OrderRepository extends JpaRepository<Orders , Long>{
    
}
