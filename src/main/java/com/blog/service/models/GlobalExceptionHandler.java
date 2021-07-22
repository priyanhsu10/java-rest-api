package com.blog.service.models;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.xml.bind.ValidationException;

@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ValidationException.class)
    ErrorMessage validationExceptionHandler(ValidationException exp) {
        return new ErrorMessage(HttpStatus.BAD_REQUEST.toString(), exp.getMessage());
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ErrorMessage methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException exp) {
        var error = new ErrorMessage();
        exp.getBindingResult()
                .getFieldErrors()
                .stream()
                .forEach(x -> error.addErrorMessage(x.getField() + " : " + x.getDefaultMessage()));
        return error;
    }


//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ExceptionHandler(Exception.class)
//    ErrorMessage serverExceptionHnadler(Exception exp) {
//        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.toString(), exp.getMessage());
//    }

}
