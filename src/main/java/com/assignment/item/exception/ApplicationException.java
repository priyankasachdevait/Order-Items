package com.assignment.item.exception;


import org.springframework.http.HttpStatus;

public class ApplicationException extends ServiceException {
  private static final long serialVersionUID = 3214888091928259104L;
  private static final HttpStatus HTTP_STATUS;

  public ApplicationException(String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  public ApplicationException(Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }

  static {
    HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;
  }
}

