package com.moonlight.groceryapi.enums;

import lombok.Getter;

public enum MessageProperties {

    PRODUCT_ADDED("Product Details Added Successfully!"),
    PRODUCT_DELETED("Product Deleted Successfully"),
    PRODUCT_NOT_FOUND("Product Not found for given ProductId"),

    FETCHED_ALL_PRODUCTS("All Products Fetched Successfully!"),
    ;
    @Getter
    private String message;
    MessageProperties(String message) {
        this.message = message;
    }
}
