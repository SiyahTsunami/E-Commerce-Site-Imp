package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.contracts.exception.ECommerceException;
import com.dolap.backend.ecommercesite.contracts.exception.model.ErrorDto;
import com.dolap.backend.ecommercesite.contracts.exception.model.ErrorMessage;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PrimaryControllerAdvice {

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto jsonFormatException(InvalidFormatException ex) {
        ErrorDto response = new ErrorDto();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setMessages(Collections.singletonList(new ErrorMessage(ex.getOriginalMessage())));

        return response;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto methodArgumentNotValidException(MethodArgumentNotValidException ex) {
        ErrorDto response = new ErrorDto();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());

        List<ErrorMessage> errorMessages = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errorMessages.add(new ErrorMessage(error.getField() + " : " + error.getDefaultMessage()));
        }
        response.setMessages(errorMessages);

        return response;
    }

    @ExceptionHandler(ECommerceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto eCommerceException(ECommerceException ex) {
        ErrorDto response = new ErrorDto();

        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setMessages(Collections.singletonList(new ErrorMessage(ex.getMessage())));

        return response;
    }

}
