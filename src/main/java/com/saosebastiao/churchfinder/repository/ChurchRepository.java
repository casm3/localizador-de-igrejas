package com.saosebastiao.churchfinder.repository;

import com.saosebastiao.churchfinder.entity.Church;
import com.saosebastiao.churchfinder.entity.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Optional;

import static com.saosebastiao.churchfinder.util.CoordinateUtil.coordinateDistance;

@Repository
public interface ChurchRepository extends JpaRepository<Church, Long> {
  public default Optional<Church> getClosestChurch(Coordinate coordinate, double maxDistance) {
    return findAll().stream().map(church -> Map.entry(church, coordinateDistance(church.getCoordinate(), coordinate)))
            .filter(entry -> entry.getValue() <= maxDistance)
            .sorted(Comparator.comparingDouble(Entry::getValue))
            .map(Entry::getKey).findFirst();
  }
}
