package com.moonlight.groceryapi.builder;

import com.moonlight.groceryapi.config.UniqueIdGenerator;
import com.moonlight.groceryapi.dto.ProductRequest;
import com.moonlight.groceryapi.entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProductBuilder {

    public Product buildProduct(ProductRequest request) {
        return Product.builder()
                .productId(new UniqueIdGenerator().generateNextNumericUniqueProductId())
                .productName(request.getProductName())
                .productDescription(request.getProductDescription())
                .productImage(request.getProductImage())
                .productQuantity(request.getProductQuantity())
                .productPrice(request.getProductPrice())
                .build();
    }
}
