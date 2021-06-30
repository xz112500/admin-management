package com.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Clockintime {

  private int staffId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date clockInTime;

  public Clockintime() {
  }


  public int getStaffId() {
    return staffId;
  }

  public void setStaffId(int staffId) {
    this.staffId = staffId;
  }

  public Date getClockInTime() {
    return clockInTime;
  }

  public void setClockInTime(Date clockInTime) {
    this.clockInTime = clockInTime;
  }
}
