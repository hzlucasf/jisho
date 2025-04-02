package com.hzlucasf.jisho.model.exception.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"error", "message"})
public class DetailedExceptionResponse extends ExceptionResponse {
    private String error;

    public DetailedExceptionResponse(String message, String error) {
        super(message);

        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
