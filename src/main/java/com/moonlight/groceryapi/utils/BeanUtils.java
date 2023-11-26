package com.moonlight.groceryapi.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeanUtils {

    @Autowired
    private ApplicationContext context;

    public Object fetchBean(String beanId) {
        try {
            return context.getBean(beanId);
        } catch (Exception e) {
            return null;
        }
    }
}
