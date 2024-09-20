package com.saosebastiao.churchfinder.entity;

/**
 * The enum Role.
 */
public enum Role {
  /**
   * Secretario role.
   */
  SECRETARIO("ROLE_SECRETARIO"),
  /**
   * Paroco role.
   */
  PAROCO("ROLE_PAROCO");

  private final String name;

  Role(String name) {
    this.name = name;
  }

  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }
}
