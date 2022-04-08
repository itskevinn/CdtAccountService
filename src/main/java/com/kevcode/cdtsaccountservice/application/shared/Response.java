package com.kevcode.cdtsaccountservice.application.shared;

import org.springframework.http.HttpStatus;

public class Response<T> {

    private String message;

    private String exceptionMessage;

    private HttpStatus status;

    private T body;

    public Response(T body, HttpStatus status, String message, String exceptionMessage) {
        this.message = message;
        this.body = body;
        this.exceptionMessage = exceptionMessage;
        this.status = status;
    }

    public Response(T body, HttpStatus status) {
        this.body = body;
        this.status = status;
    }

    public Response(T body, HttpStatus status, String message) {
        this.message = message;
        this.body = body;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getExceptionMessage() {
        return exceptionMessage;
    }

    public void setExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
