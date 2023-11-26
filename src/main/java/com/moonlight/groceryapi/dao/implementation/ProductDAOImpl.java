package com.moonlight.groceryapi.dao.implementation;

import com.moonlight.groceryapi.dao.interfaces.IProductDAO;
import com.moonlight.groceryapi.entity.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository(value = "productRepo")
public class ProductDAOImpl extends AbstractBaseDaoImpl<Product> implements IProductDAO {
    @Override
    public Mono<Product> saveProduct(Product product) {
        return save(product);
    }

    @Override
    public Flux<Product> findAllProducts() {
        return findAll(Product.class);
    }

    @Override
    public Mono<Long> deleteProductById(Long productId) {
        return deleteById(Product.class, "productId", productId);
    }

    @Override
    public Mono<Product> findProductById(Long productId) {
        return findById(Product.class, "productId", productId);
    }

    @Override
    public Mono<Long> deleteProduct(Product product) {
        return delete(product);
    }

    @Override
    public Mono<Product> updateProduct(Product product) {
        return update(product);
    }
}
