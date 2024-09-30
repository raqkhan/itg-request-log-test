package com.teamitg;

import java.io.Reader;
import java.util.List;

public class DataFilterer {

  public static List<RequestLog> filterByCountry(Reader source, String country) {
    return List.of();
  }

  public static List<RequestLog> filterByCountryWithResponseTimeAboveLimit(Reader source, String country, long limit) {
    return List.of();
  }

  public static List<RequestLog> filterByResponseTimeAboveAverage(Reader source) {
    return List.of();
  }
}
