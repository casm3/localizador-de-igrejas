package com.saosebastiao.churchfinder.controller.dto;

import com.saosebastiao.churchfinder.entity.Person;
import com.saosebastiao.churchfinder.entity.Role;

public record PersonDto(String username, String password, Role role) {
  public Person toEntity() {
    Person person = new Person();
    person.setUsername(username);
    person.setPassword(password);
    person.setRole(role);
    return person;
  }
}
