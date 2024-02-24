package com.alumnione.ecommerce.handlers.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CustomErrorResponse> handAllExceptions(Exception ex, WebRequest req){

        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDate.now(),
                req.getDescription(true)
        );
        log.info("Exception executed: "+ex.getClass());
        log.warn("Exception message: "+ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex,
                                                                   HttpHeaders headers, HttpStatusCode status,
                                                                   WebRequest request) {
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDate.now(),
                request.getDescription(true)
        );

        log.info("Exception executed: "+ex.getClass());
        log.warn("Exception message: "+ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatusCode status,
                                                                  WebRequest request) {

        Map<String, String> message = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors().forEach(fieldError -> {
                    message.put(fieldError.getField(),fieldError.getDefaultMessage());
                });

        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDate.now(),
                message,
                request.getDescription(true)
        );
        log.info("Exception executed: "+ex.getClass());
        log.warn("Exception message: "+ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SQLException.class)
    public ResponseEntity<CustomErrorResponse> SQLException(SQLException ex, WebRequest req){
        CustomErrorResponse errorResponse = new CustomErrorResponse(
                LocalDate.now(),
                req.getDescription(true)
        );
        log.info("Exception executed: "+ex.getClass());
        log.warn("Exception message: "+ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }
}
