package com.saosebastiao.churchfinder.controller.dto;

import com.saosebastiao.churchfinder.entity.Church;
import com.saosebastiao.churchfinder.entity.Coordinate;

public class EntityMapper {
  public static Church toChurch(ChurchDto churchDto) {
    Church church = new Church();
    church.setName(churchDto.name());
    church.setCoordinate(churchDto.coordinate());
    church.setUrl(church.getName());
    return church;
  }

  public static Coordinate toCoordinate(CoordinateDto coordinateDto) {
    Coordinate coordinate = new Coordinate();
    coordinate.setLatitude(coordinateDto.latitude());
    coordinate.setLongitude(coordinateDto.longitude());
    return coordinate;
  }
}
