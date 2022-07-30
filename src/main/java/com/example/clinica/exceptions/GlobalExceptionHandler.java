package com.example.clinica.exceptions;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResponseEntity<?> erroresTodos(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return new ResponseEntity("Error: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity procesarErrorNotFound(ResourceNotFoundException ex){
        logger.error(ex.getMessage());
        return new ResponseEntity("Error - " + ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
