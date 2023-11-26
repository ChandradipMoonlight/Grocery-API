package com.moonlight.groceryapi.entity;

import lombok.Data;

@Data
public class Address {
    private String pinCode;
    private String State;
    private String city;
    private String addressLine1;
    private String addressLine2;
    private String addressType;
}
