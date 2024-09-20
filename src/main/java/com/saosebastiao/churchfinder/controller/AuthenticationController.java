package com.saosebastiao.churchfinder.controller;

import com.saosebastiao.churchfinder.entity.Person;
import com.saosebastiao.churchfinder.service.PersonService;
import com.saosebastiao.churchfinder.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  private final AuthenticationManager authenticationManager;
  private final PersonService personService;
  private final TokenService tokenService;


  @Autowired
  public AuthenticationController(AuthenticationManager authenticationManager, PersonService personService, TokenService tokenService) {
    this.authenticationManager = authenticationManager;
    this.personService = personService;
    this.tokenService = tokenService;
  }

  @PostMapping("/register")
  @ResponseStatus(HttpStatus.CREATED)
  public PersonResponseDto register(@RequestBody PersonCreationDto personCreationDto) {
    Person person personService.create(personCreationDto.toEntity());
    return PersonResponseDto.fromEntity(person);
  }
}
