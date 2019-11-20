package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.domain.constants.exceptions.model.ErrorDto;
import com.dolap.backend.ecommercesite.domain.constants.exceptions.model.ErrorMessage;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class PrimaryControllerAdvice {

    @ExceptionHandler(InvalidFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDto jsonFormatException(InvalidFormatException ex) {
        ErrorDto response = new ErrorDto();
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        response.setMessages(Collections.singletonList(new ErrorMessage(ex.getTargetType().toString(), ex.getOriginalMessage())));

        return response;
    }

}
