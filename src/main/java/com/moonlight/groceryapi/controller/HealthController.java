package com.moonlight.groceryapi.controller;

import com.moonlight.groceryapi.config.UniqueIdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/health")
@Slf4j
public class HealthController {

    @GetMapping("/check")
    Mono<String> checkHealth() {
        return Mono.just("Working!"+new UniqueIdGenerator().generateNextNumericUniqueUserId());
    }
}
