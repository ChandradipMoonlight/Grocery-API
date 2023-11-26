package com.moonlight.groceryapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "db.credential")
public class DBProperties {
    private Integer port;
    private String username;
    private String password;
    private String database;
    private String host;
    private String socketPath;

}
