package com.saosebastiao.churchfinder.entity;

public enum Role {
  SECRETARIO("ROLE_SECRETARIO"),
  PAROCO("ROLE_PAROCO");

  private final String name;

  Role(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
