package com.saosebastiao.churchfinder.controller;

import com.saosebastiao.churchfinder.controller.dto.ChurchDto;
import com.saosebastiao.churchfinder.controller.dto.EntityMapper;
import com.saosebastiao.churchfinder.entity.Church;
import com.saosebastiao.churchfinder.entity.Coordinate;
import com.saosebastiao.churchfinder.service.ChurchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/churches")
public class ChurchController {
  private final ChurchService service;

  @Autowired
  public ChurchController(ChurchService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Church createChurch(@RequestBody ChurchDto churchDto) {
    return service.createChurch(EntityMapper.toChurch(churchDto));
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<Church> findAllChurches() {
    return service.findAllChurches();
  }

  @GetMapping("/closest")
  @ResponseStatus(HttpStatus.OK)
  public Church getClosestChurch(
          @RequestParam(name = "lat") double lat,
          @RequestParam(name = "lon") double lon,
          @RequestParam(name = "max_dist_km") double maxDistance) {
    return service.getClosestChurch(new Coordinate(lat, lon), maxDistance);
  }


  @GetMapping("/{churchId}")
  @ResponseStatus(HttpStatus.OK)
  public Church findChurchById(@PathVariable Long churchId) {
    return service.findChurchById(churchId);
  }


  @GetMapping("/name/{churchName}")
  @ResponseStatus(HttpStatus.OK)
  public Church findChurchByName(@PathVariable String churchName) {
    return service.findChurchByName(churchName);
  }

  @PatchMapping("/{churchId}")
  @ResponseStatus(HttpStatus.OK)
  public Church updateChurch(@PathVariable Long churchId, ChurchDto churchDto) {
    return service.updateChurch(churchId, EntityMapper.toChurch(churchDto));
  }

  @DeleteMapping("/{churchId}")
  @ResponseStatus(HttpStatus.OK)
  public void deleteChurch(@PathVariable Long churchId) {
    service.deleteChurch(churchId);
  }


}
