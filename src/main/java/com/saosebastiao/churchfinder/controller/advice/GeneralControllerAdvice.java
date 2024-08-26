package com.saosebastiao.churchfinder.controller.advice;

import com.saosebastiao.churchfinder.service.exception.CustomNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * The type General controller advice.
 */
@RestControllerAdvice
public class GeneralControllerAdvice {
  @ExceptionHandler
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleNotFoundException(CustomNotFoundException e) {
    return e.getMessage();
  }
}
