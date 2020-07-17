package com.assignment.item.advice;

import com.assignment.item.exception.ApplicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
@Slf4j
public class GenericAdvice {

  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
    log.error("RuntimeException : ", e);
    return error(INTERNAL_SERVER_ERROR, e);
  }

  @ExceptionHandler({ApplicationException.class})
  public ResponseEntity<String> handleNotFoundException(ApplicationException e) {
    log.error("ApplicationException : ", e);
    return error(NOT_FOUND, e);
  }

  private ResponseEntity<String> error(HttpStatus status, Exception e) {
    log.error("Exception : ", e);
    return ResponseEntity.status(status).body(e.getMessage());
  }
}
