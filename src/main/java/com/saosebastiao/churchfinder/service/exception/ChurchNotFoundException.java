package com.saosebastiao.churchfinder.service.exception;

/**
 * The type Church not found exception.
 */
public class ChurchNotFoundException extends CustomNotFoundException {
  public ChurchNotFoundException() {
    super("Church not found!");
  }
}
