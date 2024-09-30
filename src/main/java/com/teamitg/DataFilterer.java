package com.teamitg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataFilterer {

  public static List<RequestLog> filterByCountry(Reader source, String country) {
    try {
      List<RequestLog> requestLogs = readLog(source);
      return requestLogs.stream()
              .filter(responseLog -> responseLog.getCountryCode().equals(country))
              .toList();
    } catch (IOException e) {
      System.err.println("Error reading log file: " + e.getMessage());
      return Collections.emptyList();
    }
  }

  public static List<RequestLog> filterByCountryWithResponseTimeAboveLimit(Reader source, String country, long limit) {


    return List.of();
  }

  public static List<RequestLog> filterByResponseTimeAboveAverage(Reader source)

  {
    return List.of();
  }

  public static List<RequestLog> readLog(Reader source) throws IOException {
    List<RequestLog> requestLogs = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(source)) {
      String line;
      boolean headerRow = true;

      while ((line = reader.readLine()) != null) {
        if (headerRow) {
          headerRow = false;
          continue;
        }

        String[] fields = line.split(",");
        if (fields.length != 3) {
          System.err.println("Invalid data: " + line);
          continue;
        }

        long timestamp = Long.parseLong(fields[0]);
        String countryCode = fields[1];
        long responseTime = Long.parseLong(fields[2]);

        RequestLog requestLog = new RequestLog(
                Instant.ofEpochSecond(timestamp),
                countryCode,
                responseTime
        );
        requestLogs.add(requestLog);
      }
    }
    return requestLogs;
  }
}
