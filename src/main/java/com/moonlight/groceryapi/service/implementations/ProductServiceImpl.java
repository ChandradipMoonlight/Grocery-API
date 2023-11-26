package com.moonlight.groceryapi.service.implementations;

import com.moonlight.groceryapi.builder.ProductBuilder;
import com.moonlight.groceryapi.dao.interfaces.IProductDAO;
import com.moonlight.groceryapi.dto.ProductRequest;
import com.moonlight.groceryapi.entity.Product;
import com.moonlight.groceryapi.repo.ProductRepo;
import com.moonlight.groceryapi.service.interfaces.IProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service(value = "productService")
@Slf4j
public class ProductServiceImpl implements IProductService {

    @Autowired
    @Qualifier(value = "productRepo")
    private IProductDAO productDAO;

    @Autowired
    @Qualifier(value = "productR")
    private ProductRepo productRepo;
    @Autowired
    private ProductBuilder productBuilder;
    @Override
    public Mono<Product> addProduct(ProductRequest productRequest) {
        return productDAO.saveProduct(productBuilder.buildProduct(productRequest));
//        return productRepo.save(productBuilder.buildProduct(productRequest));
    }

    @Override
    public Flux<Product> findAllProducts() {
        return productDAO.findAllProducts()
                .map(product -> {
                    log.info("All Product Details : {}", product);
                    return product;
                });
    }

    @Override
    public Mono<Long> deleteProductById(Long productId) {
        return productDAO.findProductById(productId)
                .flatMap(product -> {
                    return productDAO.deleteProductById(product.getProductId())
                            .map(e -> {
                                log.info("Delete product, ProductId : {}", product.getProductId());
                                return e;
                            });
                })
                .switchIfEmpty(Mono.empty());
    }
}
