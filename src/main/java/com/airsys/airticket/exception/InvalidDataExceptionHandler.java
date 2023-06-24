package com.airsys.airticket.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.InvalidClassException;

@RestControllerAdvice
public class InvalidDataExceptionHandler {
    @ExceptionHandler(InvalidDataException.class)
   ResponseEntity<ApiResponse> invalidDataExceptionHandler(InvalidDataException ex){
        String msg=ex.getMessage();
        ApiResponse response=ApiResponse.builder()
                .message(msg)
                .success(false)
                .build();
        return new ResponseEntity<ApiResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    ResponseEntity<ApiResponse>ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String msg=ex.getMessage();
        ApiResponse response=ApiResponse.builder()
                .message(msg)
                .success(false)
                .build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(SourceDestinationError.class)
    ResponseEntity<ApiResponse> SourceDestinationError(SourceDestinationError ex){
        String msg=ex.getMessage();
        ApiResponse response=ApiResponse.builder()
                .message(msg)
                .success(false)
                .build();
        return new ResponseEntity<ApiResponse>(response,HttpStatus.BAD_REQUEST);
    }

}
