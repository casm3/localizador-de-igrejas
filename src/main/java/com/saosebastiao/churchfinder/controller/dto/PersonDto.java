package com.saosebastiao.churchfinder.controller.dto;

import com.saosebastiao.churchfinder.entity.Person;
import com.saosebastiao.churchfinder.entity.Role;

public record PersonDto(String username, String password, Role role) {
}
