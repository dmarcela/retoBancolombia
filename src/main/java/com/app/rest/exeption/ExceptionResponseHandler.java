package com.app.rest.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class ExceptionResponseHandler {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handlerException(Exception ex, WebRequest request) {
    ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
  }

  @ExceptionHandler(ModelNotFoundException.class)
  public ResponseEntity<ExceptionResponse> handlerModelNotFoundException(ModelNotFoundException ex, WebRequest request) {
    ExceptionResponse er = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
  }
}
