package com.saosebastiao.churchfinder.service;

import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TokenService {
  private final Algorithm algorithm;

  public TokenService(@Value("${church.security.token.secret}") String secret) {
    this.algorithm = Algorithm.HMAC256(secret);
  }
}
