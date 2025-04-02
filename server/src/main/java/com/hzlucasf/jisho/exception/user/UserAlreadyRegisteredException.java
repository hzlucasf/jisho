package com.hzlucasf.jisho.exception.user;

public class UserAlreadyRegisteredException extends RuntimeException {
    public UserAlreadyRegisteredException(String message) {
        super(message);
    }
}
