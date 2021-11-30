package com.murilonerdx.helpdesk.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;



import java.util.Date;

@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<FieldExcetionError> handleAllExceptions(Exception ex, WebRequest request) {
        FieldExcetionError exceptionResponse =
                new FieldExcetionError(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<FieldExcetionError> handleBadRequestExceptions(Exception ex, WebRequest request) {
        FieldExcetionError exceptionResponse =
                new FieldExcetionError(
                        new Date(),
                        ex.getMessage(),
                        request.getDescription(false));
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlevalidationErrors(MethodArgumentNotValidException ex,
                                                          HttpServletRequest request) {
        FieldExcetionError errors =
                new FieldExcetionError(
                        new Date(),
                        ex.getMessage(),
                        request.getContextPath());

        for(FieldError x : ex.getBindingResult().getFieldErrors()) {
            errors.getErrors().add(new FieldMessage(x.getField(), x.getDefaultMessage()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors.getErrors());
    }
}
