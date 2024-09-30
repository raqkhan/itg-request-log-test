package com.teamitg;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


class DataFiltererTest {

  @Test
  void shouldReturnEmptyList_WhenLogFileIsEmpty() throws FileNotFoundException {
    assertTrue(DataFilterer.filterByCountry(openFile(EMPTY_FILE), MATCHED_COUNTRY_GB).isEmpty());
  }

  @Test
  void shouldReturnEmptyList_WhenLogFileIsInvalid() throws FileNotFoundException {
    assertTrue(DataFilterer.filterByCountry(openFile(INVALID_FILE), MATCHED_COUNTRY_GB).isEmpty());
  }

  @Test
  void shouldReturnMatchedResults_WhenCountryIsFound() throws FileNotFoundException {
    assertTrue(!DataFilterer.filterByCountry(openFile(MULTI_LINE_FILE), MATCHED_COUNTRY_US).isEmpty() &&
            DataFilterer.filterByCountry(openFile(MULTI_LINE_FILE), MATCHED_COUNTRY_US)
                    .stream()
                    .allMatch(log -> MATCHED_COUNTRY_US.equalsIgnoreCase(log.getCountryCode())));
  }

  @Test
  void shouldReturnEmptyList_WhenCountryNotFound() throws FileNotFoundException {
    assertTrue(DataFilterer.filterByCountry(openFile(MULTI_LINE_FILE), UNMATCHED_COUNTRY_SG).isEmpty());
  }

  @Test @Disabled
  void shouldReturnMatchedResults_WithLowerResponseTime() {

  }

  @Test @Disabled
  void shouldReturnMatchedResults_WithHigherResponseTime() { }

  @Test @Disabled
  void shouldReturnList_WithResponseTimeAboveAverage() { }

  // Constants
  private static final String EMPTY_FILE = "src/test/resources/empty";
  private static final String INVALID_FILE = "src/test/resources/invalid";
  private static final String MULTI_LINE_FILE = "src/test/resources/multi-lines";
  private static final String FILE_NOT_FOUND = "src/test/resources/not-found";
  private static final String SINGLE_LINE_FILE = "src/test/resources/single-line";

  private static final String MATCHED_COUNTRY_US = "US";
  private static final String MATCHED_COUNTRY_GB = "GB";
  private static final String UNMATCHED_COUNTRY_SG = "SG";

  private static final long MATCHED_RESPONSE_TIME = 200;
  private static final long UNMATCHED_RESPONSE_TIME = 1000;

  private FileReader openFile(String filename) throws FileNotFoundException {
    return new FileReader(filename);
  }
}
