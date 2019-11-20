package com.dolap.backend.ecommercesite.infrastructure.operations;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class DateOperations {

    private final LocalDateTime date;

    public DateOperations(LocalDateTime date) {
        this.date = date;
    }

    public DateOperations(Date date) {
        this.date = date.toInstant()
                .atZone(ZoneId.of("Asia/Istanbul"))
                .toLocalDateTime();
    }

    public DateOperations(String date) {
        this.date = LocalDateTime.parse(date);
    }

    public static DateOperations of(String date) {
        return new DateOperations(date);
    }

    public static DateOperations of(Date date) {
        return new DateOperations(date);
    }

    public static String getNow() {
        return new DateOperations(LocalDateTime.now()).toString();
    }

    @Override
    public String toString() {
        return date.toString();
    }
}
