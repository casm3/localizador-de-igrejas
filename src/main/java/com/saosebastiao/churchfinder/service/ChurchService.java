package com.saosebastiao.churchfinder.service;

import static com.saosebastiao.churchfinder.util.CoordinateUtil.isCoordinateValid;

import com.saosebastiao.churchfinder.entity.Church;
import com.saosebastiao.churchfinder.entity.Coordinate;
import com.saosebastiao.churchfinder.repository.ChurchRepository;
import com.saosebastiao.churchfinder.repository.CoordinateRepository;
import com.saosebastiao.churchfinder.service.exception.ChurchNotFoundException;
import com.saosebastiao.churchfinder.service.exception.InvalidCoordinateException;
import com.saosebastiao.churchfinder.util.PropertyMapper;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Church service.
 */
@Service
public class ChurchService {
  private final ChurchRepository churchRepository;
  private final CoordinateRepository coordinateRepository;

  /**
   * Instantiates a new Church service.
   *
   * @param churchRepository     the church repository
   * @param coordinateRepository the coordinate repository
   */
  @Autowired
  public ChurchService(
          ChurchRepository churchRepository,
          CoordinateRepository coordinateRepository) {
    this.churchRepository = churchRepository;
    this.coordinateRepository = coordinateRepository;
  }

  /**
   * Gets closest church.
   *
   * @param coordinate  the coordinate
   * @param maxDistance the max distance
   * @return the closest church
   */
  public Church getClosestChurch(Coordinate coordinate, double maxDistance) {
    if (!isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }
    Optional<Church> closestChurch = churchRepository.getClosestChurch(coordinate, maxDistance);

    return closestChurch.orElseThrow(ChurchNotFoundException::new);
  }

  /**
   * Create church.
   *
   * @param church the church
   * @return the church
   */
  public Church createChurch(Church church) {
    Coordinate coordinate = church.getCoordinate();
    if (coordinate != null && isCoordinateValid(coordinate)) {
      coordinate = coordinateRepository.save(coordinate);
    }
    church.setCoordinate(coordinate);
    return churchRepository.save(church);
  }

  /**
   * Find church by id church.
   *
   * @param id the id
   * @return the church
   */
  public Church findChurchById(Long id) {
    return churchRepository.findById(id).orElseThrow(ChurchNotFoundException::new);
  }

  /**
   * Find church by name church.
   *
   * @param name the name
   * @return the church
   */
  public Church findChurchByName(String name) {
    return churchRepository.findByName(name).orElseThrow(ChurchNotFoundException::new);
  }

  /**
   * Find all churches list.
   *
   * @return the list
   */
  public List<Church> findAllChurches() {
    return churchRepository.findAll();
  }

  /**
   * Delete church.
   *
   * @param id the id
   */
  public void deleteChurch(Long id) {
    Church church = findChurchById(id);
    Coordinate coordinate = church.getCoordinate();
    if (coordinate != null) {
      coordinateRepository.delete(coordinate);
    }
    churchRepository.deleteById(id);
  }

  /**
   * Update church.
   *
   * @param id     the id
   * @param church the church
   * @return the church
   */
  public Church updateChurch(Long id, Church church) {
    Church churchFromDb = findChurchById(id);
    Coordinate coordinate = church.getCoordinate();
    if (coordinate != null && isCoordinateValid(coordinate)) {
      coordinateRepository.save(coordinate);
      churchFromDb.setCoordinate(coordinate);
    }
    PropertyMapper.copyNonNullProperties(church, churchFromDb);
    return churchRepository.save(churchFromDb);
  }
}
