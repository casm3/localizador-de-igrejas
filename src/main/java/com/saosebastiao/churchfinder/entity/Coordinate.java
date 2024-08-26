package com.saosebastiao.churchfinder.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordinate {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Double latitude;
  private Double longitude;

  public Coordinate(Double latitude, Double longitude) {
    this.latitude = latitude;
    this.longitude = longitude;
  }
}
