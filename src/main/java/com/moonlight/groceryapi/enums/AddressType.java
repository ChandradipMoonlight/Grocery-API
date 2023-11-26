package com.moonlight.groceryapi.enums;

import lombok.Getter;

public enum AddressType {
    HOME("HOME"),
    WORK("WORK");

    @Getter
    private String addressType;
    AddressType(String addressType) {
        this.addressType = addressType;
    }

}
