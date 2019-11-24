package com.dolap.backend.ecommercesite.infrastructure.operations;

import java.time.LocalDateTime;

public class DateOperations {

    private final LocalDateTime date;

    public DateOperations(LocalDateTime date) {
        this.date = date;
    }

    public static String getNow() {
        return new DateOperations(LocalDateTime.now()).toString();
    }

    @Override
    public String toString() {
        return date.toString();
    }

}
