package net.mihussain.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception{

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionMessage> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException, WebRequest webRequest) {
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                "Data not found",
                resourceNotFoundException.getMessage(),
                webRequest.getDescription(false),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);

    }
    }

