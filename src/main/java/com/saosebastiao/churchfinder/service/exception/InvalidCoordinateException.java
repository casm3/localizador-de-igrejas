package com.saosebastiao.churchfinder.service.exception;

public class InvalidCoordinateException extends CustomNotFoundException {
  public InvalidCoordinateException() {
    super("Invalid coordinate!");
  }
}
