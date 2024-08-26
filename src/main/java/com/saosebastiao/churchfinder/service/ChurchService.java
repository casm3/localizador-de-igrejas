package com.saosebastiao.churchfinder.service;

import com.saosebastiao.churchfinder.entity.Church;
import com.saosebastiao.churchfinder.entity.Coordinate;
import com.saosebastiao.churchfinder.repository.ChurchRepository;
import com.saosebastiao.churchfinder.service.exception.ChurchNotFoundException;
import com.saosebastiao.churchfinder.service.exception.InvalidCoordinateException;
import com.saosebastiao.churchfinder.util.PropertyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.saosebastiao.churchfinder.util.CoordinateUtil.isCoordinateValid;

@Service
public class ChurchService {
  private final ChurchRepository churchRepository;

  @Autowired
  public ChurchService(ChurchRepository churchRepository) {
    this.churchRepository = churchRepository;
  }

  public Church getClosestChurch(Coordinate coordinate, double maxDistance) {
    if (!isCoordinateValid(coordinate)) {
      throw new InvalidCoordinateException();
    }
    Optional<Church> closestChurch = churchRepository.getClosestChurch(coordinate, maxDistance);

    return closestChurch.orElseThrow(ChurchNotFoundException::new);
  }

  public Church createChurch(Church church) {
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
    churchRepository.deleteById(id);
  }

  public Church updateChurch(Long id, Church church) {
    Church churchFromDb = findChurchById(id);
    PropertyMapper.copyNonNullProperties(church, churchFromDb);
    return churchRepository.save(churchFromDb);
  }
}
