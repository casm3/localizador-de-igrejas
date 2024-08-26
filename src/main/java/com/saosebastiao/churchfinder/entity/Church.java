package com.saosebastiao.churchfinder.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Church.
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Church {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String name;

  @OneToOne(cascade = CascadeType.ALL)
  private Coordinate coordinate;
  private String url;
}
