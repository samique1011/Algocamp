package com.example.FakeCommerce.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.FakeCommerce.schema.Review;

public interface ReviewRepository extends JpaRepository<Review , Long> {
    @Query ("""
            Select r from Review r
             JOIN FETCH r.product
            JOIN FETCH r.order
            """)
    public List<Review> findAllReviewsWithProductAndOrder();

    @Query ("""
            Select r from Review r
            JOIN FETCH r.product
            JOIN FETCH r.order
            """)
    public Optional<Review> findReviewById(Long id);

    @Query ("""
            Select r from Review r
            JOIN FETCH r.product
            JOIN FETCH r.order
            WHERE r.product.id = :productId
            """)
    public List<Review> findReviewsByProductId(@Param("productId") Long productId);

    @Query ("""
            Select r from Review r
            JOIN FETCH r.product
            JOIN FETCH r.order
            WHERE r.order.id = :orderId
            """)
    public List<Review> findReviewsByOrderId(@Param("orderId") Long orderId);
}
