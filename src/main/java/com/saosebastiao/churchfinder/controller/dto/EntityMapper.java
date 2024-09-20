package com.saosebastiao.churchfinder.controller.dto;

import com.saosebastiao.churchfinder.entity.Church;
import com.saosebastiao.churchfinder.entity.Coordinate;
import com.saosebastiao.churchfinder.entity.Person;

/**
 * The type Entity mapper.
 */
public class EntityMapper {
  /**
   * To church.
   *
   * @param churchDto the church dto
   * @return the church
   */
  public static Church toChurch(ChurchDto churchDto) {
    Church church = new Church();
    church.setName(churchDto.name());
    church.setCoordinate(churchDto.coordinate());
    church.setUrl(church.getName());
    return church;
  }

  /**
   * To coordinate.
   *
   * @param coordinateDto the coordinate dto
   * @return the coordinate
   */
  public static Coordinate toCoordinate(CoordinateDto coordinateDto) {
    Coordinate coordinate = new Coordinate();
    coordinate.setLatitude(coordinateDto.latitude());
    coordinate.setLongitude(coordinateDto.longitude());
    return coordinate;
  }

  public static Person toPerson() {

  }
}
