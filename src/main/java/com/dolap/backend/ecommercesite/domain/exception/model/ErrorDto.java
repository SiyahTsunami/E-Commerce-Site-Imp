package com.dolap.backend.ecommercesite.domain.exception.model;

import java.util.List;
import java.util.Objects;

public class ErrorDto {

    private int statusCode;

    private List<ErrorMessage> messages;

    public ErrorDto() {
    }

    public ErrorDto(int statusCode, List<ErrorMessage> messages) {
        this.statusCode = statusCode;
        this.messages = messages;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public List<ErrorMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<ErrorMessage> messages) {
        this.messages = messages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ErrorDto errorDto = (ErrorDto) o;
        return statusCode == errorDto.statusCode &&
                Objects.equals(messages, errorDto.messages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusCode, messages);
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "statusCode=" + statusCode +
                ", messages=" + messages +
                '}';
    }

}
