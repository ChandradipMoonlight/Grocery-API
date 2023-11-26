package com.moonlight.groceryapi.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class  ResponseWrapper implements Serializable {
    private Object data;
    private MetaInfo metaInfo;

    public ResponseWrapper (Object data, MetaInfo metaInfo) {
        this.data = data;
        this.metaInfo = metaInfo;
    }

    public static ResponseWrapper generateResponse(Object data, String status, String message, Integer statusCode, boolean error) {
        ResponseWrapper responseWrapper = new ResponseWrapper(data, MetaInfo.generateMetaInfo(status, message, statusCode, error));
        return responseWrapper;
    }

}
