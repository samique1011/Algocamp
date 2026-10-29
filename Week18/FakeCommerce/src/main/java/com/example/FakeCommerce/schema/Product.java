package com.example.FakeCommerce.schema;


import org.hibernate.annotations.DialectOverride.SQLDelete;
import org.hibernate.annotations.DialectOverride.SQLRestriction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data 
@AllArgsConstructor 
@NoArgsConstructor 
@Builder 
@Entity 
@Table(name = "products")
@Getter 
@Setter 
@org.hibernate.annotations.SQLDelete (sql = "UPDATE products SET deleted_at = CURRENT_TIMESTAMP where id = ?")
@org.hibernate.annotations.SQLRestriction ("deleted_at is NULL")
public class Product extends BaseEntity {
    @Column(nullable = false)
    private String name;

    @Column (columnDefinition = "TEXT")
    private String description;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "category_id" , nullable = false)
    private Category category;
    private String ratings;
    private String image;

}
