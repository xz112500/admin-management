package com.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Otherconsume {

  private int consumeId;
  private int tripId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date consumeTime;
  private String consumeType;
  private double cost;

  public Otherconsume() {
  }

  public int getConsumeId() {
    return consumeId;
  }

  public void setConsumeId(int consumeId) {
    this.consumeId = consumeId;
  }

  public int getTripId() {
    return tripId;
  }

  public void setTripId(int tripId) {
    this.tripId = tripId;
  }

  public Date getConsumeTime() {
    return consumeTime;
  }

  public void setConsumeTime(Date consumeTime) {
    this.consumeTime = consumeTime;
  }

  public String getConsumeType() {
    return consumeType;
  }

  public void setConsumeType(String consumeType) {
    this.consumeType = consumeType;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }
}
