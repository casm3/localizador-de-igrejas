package com.saosebastiao.churchfinder.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * The type Security configuration.
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {
  private final SecurityFilter securityFilter;

  /**
   * Instantiates a new Security configuration.
   *
   * @param securityFilter the security filter
   */
  @Autowired
  public SecurityConfiguration(SecurityFilter securityFilter) {
    this.securityFilter = securityFilter;
  }

  /**
   * Security filter chain security filter chain.
   *
   * @param httpSecurity the http security
   * @return the security filter chain
   * @throws Exception the exception
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(
                    session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/v3/**").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                    .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                    .requestMatchers(HttpMethod.GET, "/v3/**").permitAll()
                    .requestMatchers(HttpMethod.GET, "/churches").permitAll()
                    .requestMatchers(HttpMethod.POST, "/churches").permitAll()
                    .anyRequest().authenticated()
            ).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
  }

  /**
   * Password encoder password encoder.
   *
   * @return the password encoder
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  /**
   * Authentication manager authentication manager.
   *
   * @param authenticationConfiguration the authentication configuration
   * @return the authentication manager
   * @throws Exception the exception
   */
  @Bean
  public AuthenticationManager authenticationManager(
          AuthenticationConfiguration authenticationConfiguration
  ) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }
}
