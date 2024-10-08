package com.saosebastiao.churchfinder.repository;

import com.saosebastiao.churchfinder.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Coordinate repository.
 */
@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Long> {
}
