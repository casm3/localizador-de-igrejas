package com.saosebastiao.churchfinder.service.exception;

/**
 * The type Person not found exception.
 */
public class PersonNotFoundException extends CustomNotFoundException {
  /**
   * Instantiates a new Person not found exception.
   */
  public PersonNotFoundException() {
    super("Person not found!");
  }
}
