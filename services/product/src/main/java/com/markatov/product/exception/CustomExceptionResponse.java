package com.markatov.product.exception;

import lombok.Data;

import java.util.List;

@Data
public class CustomExceptionResponse {
    private String time;
    private String status;
    private List<String> errors;
}
