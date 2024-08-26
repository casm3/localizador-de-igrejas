package com.saosebastiao.churchfinder.controller.dto;

import com.saosebastiao.churchfinder.entity.Coordinate;

public record ChurchDto (
        String name,
        Coordinate coordinate,
        String url
) {
}
