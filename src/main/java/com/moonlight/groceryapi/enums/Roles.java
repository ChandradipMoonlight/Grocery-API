package com.moonlight.groceryapi.enums;

import lombok.Getter;

public enum Roles {

    ADMIN("Admin"),
    USER("User");

    @Getter
    private String role;
    Roles(String role) {
        this.role = role;
    }

}
