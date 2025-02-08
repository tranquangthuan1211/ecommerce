package com.example.ecommerce.exception;

import lombok.Getter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "user existed",HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTS(1005,"user not exists", HttpStatus.BAD_REQUEST),
    UNAUTHENTICATED(1006,"Unauthenticated",HttpStatus.INTERNAL_SERVER_ERROR),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR);
    private final int code;
    private final String message;
    private final HttpStatusCode statusCode;

    ErrorCode(int code,String message, HttpStatusCode statusCode){
        this.code = code;
        this.message = message;
        this.statusCode = statusCode;
    }
}
