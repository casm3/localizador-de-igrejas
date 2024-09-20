package com.saosebastiao.churchfinder.repository;

import com.saosebastiao.churchfinder.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

/**
 * The interface Person repository.
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
  /**
   * Find by username user details.
   *
   * @param username the username
   * @return the user details
   */
  UserDetails findByUsername(String username);
}
