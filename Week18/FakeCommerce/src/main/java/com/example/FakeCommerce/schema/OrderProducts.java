package com.example.FakeCommerce.schema;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity 
@Table (name = "order_products")
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Getter
public class OrderProducts extends BaseEntity{
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "product_id" , nullable = false)
    private Product product;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "order_id" , nullable = false)
    private Orders orders;

    private int quantity;
}
