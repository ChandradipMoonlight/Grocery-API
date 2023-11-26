package com.moonlight.groceryapi.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(name = "cartDetails")
public class Cart {
    @Id
    private long cartId;
    private long userId;
    private long productId;
    private long cartQuantity;
    private double cartPrice;
}
