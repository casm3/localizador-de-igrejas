package com.saosebastiao.churchfinder.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.saosebastiao.churchfinder.entity.Person;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * The type Token service.
 */
@Service
public class TokenService {
  private final Algorithm algorithm;

  /**
   * Instantiates a new Token service.
   *
   * @param secret the secret
   */
  public TokenService(@Value("${church.security.token.secret}") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }

  /**
   * Generate token string.
   *
   * @param person the person
   * @return the string
   */
  public String generateToken(Person person) {
    return JWT.create().withIssuer("church")
            .withSubject(person.getUsername())
            .sign(algorithm);
  }

  /**
   * Validate token string.
   *
   * @param token the token
   * @return the string
   */
  public String validateToken(String token) {
    return JWT.require(algorithm)
            .withIssuer("church")
            .build()
            .verify(token)
            .getSubject();
  }
}
