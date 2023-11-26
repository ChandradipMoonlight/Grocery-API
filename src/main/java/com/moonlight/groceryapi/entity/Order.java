package com.moonlight.groceryapi.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Builder
@Table("orderDetails")
public class Order {

    @Id
    private long orderId;
    private long userId;
    private long productId;
    private long orderQuantity;
    private long orderPrice;

}
