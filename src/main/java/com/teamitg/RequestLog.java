package com.teamitg;

import java.time.Instant;

public class RequestLog {

  private Instant requestTimestamp;
  private String countryCode;
  private long responseTime;

  public RequestLog(Instant requestTimestamp, String countryCode, long responseTime) {
    this.requestTimestamp = requestTimestamp;
    this.countryCode = countryCode;
    this.responseTime = responseTime;
  }

  public Instant getRequestTimestamp() {
    return requestTimestamp;
  }

  public void setRequestTimestamp(Instant requestTimestamp) {
    this.requestTimestamp = requestTimestamp;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public long getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(long responseTime) {
    this.responseTime = responseTime;
  }
}
