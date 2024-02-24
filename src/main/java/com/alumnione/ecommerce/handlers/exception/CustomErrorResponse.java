package com.alumnione.ecommerce.handlers.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Map;

@Data
@NoArgsConstructor
public class CustomErrorResponse {

    private LocalDate  dateTime;
    private Map<String, String> messageMap;
    private String path;

    public CustomErrorResponse(LocalDate dateTime, String path) {
        this.dateTime = dateTime;
        this.path = path;
    }

    public CustomErrorResponse(LocalDate dateTime, Map<String, String> messageMap, String path){
        this.dateTime = dateTime;
        this.messageMap = messageMap;
        this.path = path;
    }
}
