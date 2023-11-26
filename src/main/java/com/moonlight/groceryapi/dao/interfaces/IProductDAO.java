package com.moonlight.groceryapi.dao.interfaces;

import com.moonlight.groceryapi.entity.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IProductDAO {
    Mono<Product> saveProduct(Product product);

    Flux<Product> findAllProducts();

    Mono<Long> deleteProductById(Long productId);
    Mono<Product> findProductById(Long productId);

    Mono<Long> deleteProduct(Product product);
    Mono<Product> updateProduct(Product product);
}
