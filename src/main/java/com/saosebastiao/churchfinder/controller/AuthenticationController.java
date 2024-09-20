package com.saosebastiao.churchfinder.controller;

import com.saosebastiao.churchfinder.controller.dto.AuthenticationDto;
import com.saosebastiao.churchfinder.controller.dto.EntityMapper;
import com.saosebastiao.churchfinder.controller.dto.PersonDto;
import com.saosebastiao.churchfinder.controller.dto.TokenDto;
import com.saosebastiao.churchfinder.entity.Person;
import com.saosebastiao.churchfinder.service.PersonService;
import com.saosebastiao.churchfinder.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
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
  public Person register(@RequestBody PersonDto personDto) {
    return personService.create(EntityMapper.toPerson(personDto));
  }

  @PostMapping("/login")
  @ResponseStatus(HttpStatus.OK)
  public TokenDto login(@RequestBody AuthenticationDto authenticationDto) {
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authenticationDto.username(), authenticationDto.password());
    Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    Person person = (Person) authenticate.getPrincipal();

    String token = tokenService.generateToken(person);

    return new TokenDto(token);
  }
}
