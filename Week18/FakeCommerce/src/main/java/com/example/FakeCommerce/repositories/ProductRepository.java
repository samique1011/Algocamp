package com.example.FakeCommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.FakeCommerce.schema.Product;

@Repository 
public interface ProductRepository extends JpaRepository<Product , Long> {
    public List<Product> findByCategory(String category);

    @Query("SELECT p.category, COUNT(p.category) FROM Product p GROUP BY p.category")
    public List<Object[]> getUniqueCategory();
}
