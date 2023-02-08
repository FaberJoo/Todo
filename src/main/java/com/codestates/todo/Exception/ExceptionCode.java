package com.codestates.todo.Exception;

import lombok.Getter;

public enum ExceptionCode {
  TODO_NOT_FOUND(404, "TODO Not Found."),
  NOT_IMPLEMENTATION(501, "Not Implementation");

  @Getter
  private int status;

  @Getter
  private String message;

  ExceptionCode(int code, String message) {
    this.status = code;
    this.message = message;
  }
}
