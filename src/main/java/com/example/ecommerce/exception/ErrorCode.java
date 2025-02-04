package com.example.ecommerce.exception;

public enum ErrorCode {
    USER_EXISTED(1001, "user existed"),
    USER_NOT_EXISTS(1005,"user not exists");
    private final int code;
    private final String message;

    ErrorCode(int code,String message){
        this.code = code;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
