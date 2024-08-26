package com.saosebastiao.churchfinder.repository;

import static com.saosebastiao.churchfinder.util.CoordinateUtil.coordinateDistance;

import com.saosebastiao.churchfinder.entity.Church;
import com.saosebastiao.churchfinder.entity.Coordinate;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface Church repository.
 */
@Repository
public interface ChurchRepository extends JpaRepository<Church, Long> {
  /**
   * Gets closest church.
   *
   * @param coordinate  the coordinate
   * @param maxDistance the max distance
   * @return the closest church
   */
  public default Optional<Church> getClosestChurch(Coordinate coordinate, double maxDistance) {
    return findAll().stream().map(church -> Map.entry(
            church, coordinateDistance(church.getCoordinate(), coordinate)))
            .filter(entry -> entry.getValue() <= maxDistance)
            .sorted(Comparator.comparingDouble(Entry::getValue))
            .map(Entry::getKey).findFirst();
  }

  /**
   * Find by name optional.
   *
   * @param name the name
   * @return the optional
   */
  Optional<Church> findByName(String name);
}
