package com.saosebastiao.churchfinder.service.exception;

public class ChurchNotFoundException extends CustomNotFoundException {
  public ChurchNotFoundException() {
    super("Church not found!");
  }
}
