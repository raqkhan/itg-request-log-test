package com.teamitg;

import java.io.Reader;
import java.util.List;

public class DataFilterer {

  public static List<?> filterByCountry(Reader source, String country) {
    return List.of();
  }

  public static List<?> filterByCountryWithResponseTimeAboveLimit(Reader source, String country, long limit) {
    return List.of();
  }

  public static List<?> filterByResponseTimeAboveAverage(Reader source) {
    return List.of();
  }
}
