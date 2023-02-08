package com.codestates.todo.Exception;

import lombok.Getter;

public class CustomException extends RuntimeException {
  @Getter
  private ExceptionCode code;

  public CustomException(ExceptionCode code) {
    super(code.getMessage());
    this.code = code;
  }
}