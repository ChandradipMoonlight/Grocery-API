package com.moonlight.groceryapi.dto;

import lombok.Data;

@Data
public class ProductRequest {
    private String productName;
    private String productDescription;
    private double productPrice;
    private long productQuantity;
    private String productImage;
}
