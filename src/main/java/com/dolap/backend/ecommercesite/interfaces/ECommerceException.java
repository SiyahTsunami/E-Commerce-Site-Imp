package com.dolap.backend.ecommercesite.interfaces;

public class ECommerceException extends RuntimeException {

    private String messageCode;

    public ECommerceException() {
    }

    public ECommerceException(String message) {
        super(message);
    }

    public ECommerceException(String type, int code) {
        super(type + "." + code);
        messageCode = type + "." + code;
    }

    public String getMessageCode() {
        return messageCode;
    }

    @Override
    public String toString() {
        return "ECommerceException{" +
                "messageCode='" + messageCode + '\'' +
                '}';
    }

}
