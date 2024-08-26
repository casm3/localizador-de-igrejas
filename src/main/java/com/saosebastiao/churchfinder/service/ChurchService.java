package com.saosebastiao.churchfinder.service;

import com.saosebastiao.churchfinder.entity.Church;
import com.saosebastiao.churchfinder.entity.Coordinate;
import com.saosebastiao.churchfinder.repository.ChurchRepository;
import com.saosebastiao.churchfinder.repository.CoordinateRepository;
import com.saosebastiao.churchfinder.service.exception.ChurchNotFoundException;
import com.saosebastiao.churchfinder.service.exception.InvalidCoordinateException;
import com.saosebastiao.churchfinder.util.PropertyMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.saosebastiao.churchfinder.util.CoordinateUtil.isCoordinateValid;

@Service
public class ChurchService {
  private final ChurchRepository churchRepository;
  private final CoordinateRepository coordinateRepository;

  @Autowired
  public ChurchService(ChurchRepository churchRepository, CoordinateRepository coordinateRepository) {
    this.churchRepository = churchRepository;
    this.coordinateRepository = coordinateRepository;
  }

  public Church getClosestChurch(Coordinate coordinate, double maxDistance) {
    if (!isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }
    Optional<Church> closestChurch = churchRepository.getClosestChurch(coordinate, maxDistance);

    return closestChurch.orElseThrow(ChurchNotFoundException::new);
  }

  public Church createChurch(Church church) {
    Coordinate coordinate = church.getCoordinate();
    if (coordinate != null && isCoordinateValid(coordinate)) {
      coordinate = coordinateRepository.save(coordinate);
    }
    church.setCoordinate(coordinate);
    return churchRepository.save(church);
  }

  public Church findChurchById(Long id) {
    return churchRepository.findById(id).orElseThrow(ChurchNotFoundException::new);
  }

  public Church findChurchByName(String name) {
    return churchRepository.findByName(name).orElseThrow(ChurchNotFoundException::new);
  }

  public List<Church> findAllChurches() {
    return churchRepository.findAll();
  }

  public void deleteChurch(Long id) {
    Church church = findChurchById(id);
    Coordinate coordinate = church.getCoordinate();
    if (coordinate != null) {
      coordinateRepository.delete(coordinate);
    }
    churchRepository.deleteById(id);
  }

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
