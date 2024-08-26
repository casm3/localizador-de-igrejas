package com.saosebastiao.churchfinder.controller.dto;

import com.saosebastiao.churchfinder.entity.Coordinate;

/**
 * The type Church dto.
 */
public record ChurchDto(
        String name,
        Coordinate coordinate,
        String url
) {
}
