package com.moonlight.groceryapi.entity;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table(name = "productDetails")
public class Product {

    @Id
    @Column(value = "productId")
    private Long productId;
    @Column(value = "productName")
    private String productName;
    @Column(value = "productDescription")
    private String productDescription;
    @Column(value = "productPrice")
    private double productPrice;
    @Column(value = "productQuantity")
    private long productQuantity;
    @Column(value = "productImage")
    private String productImage;

}
