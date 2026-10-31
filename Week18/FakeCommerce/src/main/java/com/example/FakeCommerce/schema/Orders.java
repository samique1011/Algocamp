package com.example.FakeCommerce.schema;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder
@Entity 
@Table(name = "orders")

public class Orders extends BaseEntity {
    @Column (nullable = false)
    private OrderStatus status;
}
