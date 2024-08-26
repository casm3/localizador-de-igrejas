package com.saosebastiao.churchfinder.util;

import com.saosebastiao.churchfinder.entity.Coordinate;

public class CoordinateUtil {
  public static Boolean isCoordinateValid(Coordinate coordinate) {
    return Math.abs(coordinate.getLatitude()) <= 90.0 && Math.abs(coordinate.getLongitude()) <= 180;
  }
  public static Double coordinateDistance(Coordinate coordinate1, Coordinate coordinate2) {
    return CoordinateUtil.coordinateDistance(
            Math.toRadians(coordinate1.getLatitude()),
            Math.toRadians(coordinate1.getLongitude()),
            Math.toRadians(coordinate2.getLatitude()),
            Math.toRadians(coordinate2.getLongitude()));
  }

  private static Double coordinateDistance(double lat1, double lon1, double lat2, double lon2) {
    // Haversine
    double sinLatDif = Math.sin((lat2 - lat1) / 2);
    double sinLonDif = Math.sin((lon2 - lon1) / 2);

    double a = sinLatDif * sinLatDif * Math.cos(lat1) * Math.cos(lat2) * sinLonDif * sinLonDif;
    return 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)) * 6371; //Earth Radius 6471
  }
}
