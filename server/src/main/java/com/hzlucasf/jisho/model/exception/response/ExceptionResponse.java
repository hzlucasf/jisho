package com.hzlucasf.jisho.model.exception.response;

public class ExceptionResponse {
    protected String message;

    public ExceptionResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
