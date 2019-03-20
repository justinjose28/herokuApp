package com.heroku.banks.exception;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private final String code;
  private final String message;
}
