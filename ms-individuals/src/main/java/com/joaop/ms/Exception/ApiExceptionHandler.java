package com.joaop.ms.Exception;

import com.joaop.ms.Service.Exceptions.IndividualNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(IndividualNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleMethodArgumentNotValidException(IndividualNotFoundException ex, HttpServletRequest request){
        ErrorMessage error = new ErrorMessage(
                request.getRequestURI(),
                request.getMethod(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
