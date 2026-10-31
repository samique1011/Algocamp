package com.example.FakeCommerce.schema;

import org.hibernate.annotations.SQLRestriction;

import java.math.BigDecimal;

import org.hibernate.annotations.SQLDelete;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor 
@NoArgsConstructor 
@Getter 
@Setter 
@Builder 
@Entity 
@Table(name = "reviews")
@SQLDelete (sql= "UPDATE reviews SET deleted_at = CURRENT_TIMESTAMP where id = ?")
@SQLRestriction ("deleted_at is NULL")
public class Review extends BaseEntity {
    
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "product_id" , nullable = false)
    private Product product;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "order_id" , nullable = false)
    private Orders order;

    @Column(nullable = false)
    private String reviewDescription;

    @Column (nullable = false)
    private BigDecimal ratings;
}
