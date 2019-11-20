package com.dolap.backend.ecommercesite.application.controller;

import com.dolap.backend.ecommercesite.domain.constants.exception.model.ErrorDto;
import com.dolap.backend.ecommercesite.domain.constants.exception.model.ErrorMessage;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.CompletionException;

@RestControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class SecondaryControllerAdvice {

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDto notExpectedError(Throwable throwable) {
        if (throwable instanceof CompletionException && Objects.nonNull(throwable.getCause())) {
            throwable = throwable.getCause();
        }

        ErrorDto response = new ErrorDto();
        response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessages(Collections.singletonList(new ErrorMessage(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()), throwable.getMessage())));

        return response;
    }

}
