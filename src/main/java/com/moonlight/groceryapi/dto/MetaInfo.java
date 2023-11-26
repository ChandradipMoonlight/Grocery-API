package com.moonlight.groceryapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@NoArgsConstructor
public class MetaInfo implements Serializable {
    private String status;
    private String message;
    private Integer statusCode;
    private boolean error;

    public MetaInfo(String status, boolean error, String message, Integer statusCode) {
        this.error = error;
        this.status = status;
        this.message = message;
        this.statusCode = statusCode;
    }

    public static MetaInfo generateMetaInfo(String status, String message, Integer statusCode, boolean error) {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.setError(error);
        metaInfo.setStatus(status);
        metaInfo.setStatusCode(statusCode);
        metaInfo.setMessage(message);
        return metaInfo;
    }
}
