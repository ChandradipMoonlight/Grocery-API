package com.moonlight.groceryapi.repo;

import com.moonlight.groceryapi.entity.Product;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Repository;

@Repository(value = "productR")
public interface ProductRepo extends ReactiveCrudRepository<Product, Long> {
}
