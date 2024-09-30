package com.teamitg;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class DataFiltererTest {

  @Test
  void shouldReturnEmptyList_WhenLogFileIsEmpty() throws FileNotFoundException {
    assertTrue(DataFilterer.filterByCountry(openFile("src/test/resources/empty"), "GB").isEmpty());
  }

  @Test
  void shouldReturnEmptyList_WhenLogFileIsInvalid() throws FileNotFoundException {
    assertTrue(!DataFilterer.filterByCountry(openFile("src/test/resources/empty"), "GB").isEmpty() &&
            DataFilterer.filterByCountry(openFile("src/test/resources/empty"), "GB")
                    .stream()
                    .allMatch(log -> "GB".equalsIgnoreCase(log.getCountryCode())));
  }

  @Test @Disabled
  void shouldReturnMatchedResults_WhenCountryIsFound() { }

  @Test @Disabled
  void shouldReturnEmptyList_WhenCountryNotFound() { }

  @Test @Disabled
  void shouldReturnMatchedResults_WithLowerResponseTime() { }

  @Test @Disabled
  void shouldReturnMatchedResults_WithHigherResponseTime() { }

  @Test @Disabled
  void shouldReturnList_WithResponseTimeAboveAverage() { }



  private FileReader openFile(String filename) throws FileNotFoundException {
    return new FileReader(filename);
  }
}
