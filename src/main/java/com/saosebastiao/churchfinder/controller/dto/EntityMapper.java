package com.saosebastiao.churchfinder.controller.dto;

import com.saosebastiao.churchfinder.entity.Church;

public class EntityMapper {
  public static Church toChurch(ChurchDto churchDto) {
    Church church = new Church();
    church.setName(churchDto.name());
    church.setCoordinate(churchDto.coordinate());
    church.setUrl(church.getName());
    return church;
  }
}
