package com.teamitg;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import org.junit.jupiter.api.Test;


class DataFiltererTest {

  @Test
  void shouldReturnEmptyList_WhenLogFileIsEmpty() throws FileNotFoundException {
    assertTrue(DataFilterer.filterByCountry(openFile("src/test/resources/empty"), "GB").isEmpty());
  }

  private FileReader openFile(String filename) throws FileNotFoundException {
    return new FileReader(filename);
  }
}
