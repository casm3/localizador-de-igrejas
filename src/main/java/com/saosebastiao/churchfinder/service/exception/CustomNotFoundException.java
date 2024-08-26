package com.saosebastiao.churchfinder.service.exception;

/**
 * The type Custom not found exception.
 */
public class CustomNotFoundException extends RuntimeException {
  public CustomNotFoundException() {
  }

  public CustomNotFoundException(String message) {
    super(message);
  }
}
