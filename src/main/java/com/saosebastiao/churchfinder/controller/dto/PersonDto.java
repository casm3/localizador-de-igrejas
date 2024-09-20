package com.saosebastiao.churchfinder.controller.dto;

import com.saosebastiao.churchfinder.entity.Role;

/**
 * The type Person dto.
 */
public record PersonDto(String username, String password, Role role) {
}
