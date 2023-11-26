package com.moonlight.groceryapi.controller;

import com.moonlight.groceryapi.constants.ResponseConstants;
import com.moonlight.groceryapi.dto.ProductRequest;
import com.moonlight.groceryapi.dto.ResponseWrapper;
import com.moonlight.groceryapi.entity.Product;
import com.moonlight.groceryapi.enums.MessageProperties;
import com.moonlight.groceryapi.service.interfaces.IProductService;
import com.moonlight.groceryapi.utils.BeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/admin/api")
@Slf4j
public class ProductController {

    @Autowired
    private BeanUtils beanUtils;

    @Autowired
    private IProductService productService;

    @PostMapping("/add/product")
    public Mono<ResponseEntity<ResponseWrapper>> addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest)
                .map(response ->
                        new ResponseEntity(
                            ResponseWrapper.generateResponse(
                                    response,
                                    ResponseConstants.SUCCESS,
                                    MessageProperties.PRODUCT_ADDED.getMessage(),
                                    HttpStatus.OK.value(),
                                    false
                            ),
                            HttpStatus.OK
                        )
                );
    }

    @GetMapping("/getAll/products")
    public Flux<Product> getAllProducts() {
        return productService.findAllProducts();
    }

    @DeleteMapping("/delete/product/{productId}")
    public Mono<ResponseEntity<ResponseWrapper>> removeProductById(@PathVariable Long productId) {
        return productService.deleteProductById(productId)
                .map(id -> ResponseEntity.ok(
                            ResponseWrapper.generateResponse(
                                    id,
                                    ResponseConstants.SUCCESS,
                                    MessageProperties.PRODUCT_DELETED.getMessage(),
                                    HttpStatus.OK.value(),
                                    false
                            )
                    ))
                .switchIfEmpty(
                        Mono.just(new ResponseEntity<>(
                                ResponseWrapper.generateResponse(
                                        productId,
                                        ResponseConstants.FAILURE,
                                        MessageProperties.PRODUCT_NOT_FOUND.getMessage(),
                                        HttpStatus.NOT_FOUND.value(),
                                        true
                                ),
                                HttpStatus.NOT_FOUND
                        ))
                );
    }

}
