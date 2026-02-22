package com.joaop.ms.Exception;

import com.joaop.ms.Services.Exception.AssetNotFoundException;
import com.joaop.ms.Services.Exception.IndividualNotFoundException;
import com.joaop.ms.Services.Exception.OperationNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(AssetNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleAssetNotFoundException(AssetNotFoundException ex, HttpServletRequest request){
        ErrorMessage error = new ErrorMessage(
                request.getRequestURI(),
                request.getMethod(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(OperationNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleOperationNotFoundException(OperationNotFoundException ex, HttpServletRequest request){
        ErrorMessage error = new ErrorMessage(
                request.getRequestURI(),
                request.getMethod(),
                HttpStatus.NOT_FOUND.value(),
                "Not Found",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IndividualNotFoundException.class)
    public ResponseEntity<Object> handleIndividualNotFound(IndividualNotFoundException ex) {

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }

}
