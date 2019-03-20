package com.heroku.banks.exception;

import static com.heroku.banks.Constants.RESOURCE_NOT_FOUND;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import com.heroku.banks.Constants;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(RuntimeException.class)
  public ResponseEntity<ErrorMessage> handleRuntimeException(RuntimeException e) {
    log.debug("{}", e.getMessage(), e);
    return new ResponseEntity<>(
        new ErrorMessage(Constants.INTERNAL_SERVER_ERROR, "An unexpected error has occured."),
        HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(BusinessException.class)
  public ResponseEntity<ErrorMessage> handleBusinessException(BusinessException e) {
    log.debug("{}", e.getMessage(), e);
    HttpStatus status = BAD_REQUEST;
    if (RESOURCE_NOT_FOUND.equals(e.getCode())) {
      status = NOT_FOUND;
    }
    return new ResponseEntity<>(
        new ErrorMessage(Constants.RESOURCE_NOT_FOUND, e.getMessage()), status);
  }

  @Value
  private static class ErrorMessage {
    private String code;
    private String message;
  }
}
