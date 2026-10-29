package com.example.FakeCommerce.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity 
@Table(name = "orders")
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
public class Orders extends BaseEntity {
    @Column (nullable = false)
    private OrderStatus status;
}
