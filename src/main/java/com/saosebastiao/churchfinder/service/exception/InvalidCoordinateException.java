package com.saosebastiao.churchfinder.service.exception;

/**
 * The type Invalid coordinate exception.
 */
public class InvalidCoordinateException extends CustomNotFoundException {
  public InvalidCoordinateException() {
    super("Invalid coordinate!");
  }
}
