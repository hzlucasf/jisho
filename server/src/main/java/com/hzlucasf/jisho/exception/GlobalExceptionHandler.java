package com.hzlucasf.jisho.exception;

import com.hzlucasf.jisho.exception.user.InvalidPasswordException;
import com.hzlucasf.jisho.exception.user.InvalidUsernameException;
import com.hzlucasf.jisho.exception.user.UserAlreadyRegisteredException;
import com.hzlucasf.jisho.model.exception.response.DetailedExceptionResponse;
import com.hzlucasf.jisho.model.exception.response.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ExceptionResponse exceptionHandler(Exception exception) {
        return new ExceptionResponse("internal server error");
    }

    @ExceptionHandler(InvalidUsernameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public DetailedExceptionResponse invalidUsernameExceptionHandler(InvalidUsernameException invalidUsernameException) {
        return new DetailedExceptionResponse(
                invalidUsernameException.getMessage(),
                "invalid username exception"
        );
    }

    @ExceptionHandler(InvalidPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public DetailedExceptionResponse invalidPasswordExceptionHandler(InvalidPasswordException invalidPasswordException) {
        return new DetailedExceptionResponse(
                invalidPasswordException.getMessage(),
                "invalid password exception"
        );
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public DetailedExceptionResponse userAlreadyRegisteredExceptionHandler(UserAlreadyRegisteredException userAlreadyRegisteredException) {
        return new DetailedExceptionResponse(
                userAlreadyRegisteredException.getMessage(),
                "user already registered exception"
        );
    }
}
