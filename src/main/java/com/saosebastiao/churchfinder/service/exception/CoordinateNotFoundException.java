package com.saosebastiao.churchfinder.service.exception;

public class CoordinateNotFoundException extends CustomNotFoundException {
  public CoordinateNotFoundException() {
    super("Coordinate not found!");
  }
}
