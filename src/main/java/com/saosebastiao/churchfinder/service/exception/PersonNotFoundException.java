package com.saosebastiao.churchfinder.service.exception;

public class PersonNotFoundException extends CustomNotFoundException {
  public PersonNotFoundException() {
    super("Person not found!");
  }
}
