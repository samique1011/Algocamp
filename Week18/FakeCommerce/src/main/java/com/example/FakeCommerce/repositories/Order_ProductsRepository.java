package com.example.FakeCommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.FakeCommerce.schema.OrderProducts;

public interface  Order_ProductsRepository extends JpaRepository<OrderProducts , Long> {
    @Query("""
            SELECT op FROM OrderProducts op
            JOIN FETCH op.product
            JOIN FETCH op.orders
            """)
    List<OrderProducts> findAllWithProductAndOrder();

    @Query("""
        Select op From OrderProducts op
        JOIN FETCH op.product
        JOIN FETCH op.orders
        Where op.product.id = :productId
        AND op.orders.id = :orderId
        """)
    public Optional<OrderProducts> findByProduct_IdAndOrder_Id(@Param("productId") Long productId ,@Param("orderId") Long orderId);
}
