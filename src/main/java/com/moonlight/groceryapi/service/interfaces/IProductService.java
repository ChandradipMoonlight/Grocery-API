package com.moonlight.groceryapi.service.interfaces;

import com.moonlight.groceryapi.dto.ProductRequest;
import com.moonlight.groceryapi.dto.ResponseWrapper;
import com.moonlight.groceryapi.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductService {
    Mono<Product> addProduct(ProductRequest productRequest);

    Flux<Product> findAllProducts();

    Mono<Long> deleteProductById(Long productId);

}
