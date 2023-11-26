package com.moonlight.groceryapi.entity;

import com.moonlight.groceryapi.enums.Roles;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@Table(name = "userDetails")
public class User {
    @Id
    private long userId;
    private String userFName;
    private String userMName;
    private String userLName;
    private String userMobile;
    private String userEmail;
    private String userPassword;
    private String role = Roles.USER.getRole();
    private Address address;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
