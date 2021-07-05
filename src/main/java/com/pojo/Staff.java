//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Staff {
  private int staffId;
  private String userName;
  private String password;
  private int state;
  private String staffName;
  private String gender;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
  private Date birthday;
  private int organizationId;
  private int jobId;
  private int directBoss;
  private String birthplace;
  private String position;
  private String phoneNumber;
  private String email;
  private String photoUrl;
  private String token;
  private Set<Askforleave> askforleave = new HashSet();
  private Organization organization;
  private Job job;

  public Staff() {
  }

  public int getStaffId() {
    return this.staffId;
  }

  public void setStaffId(int staffId) {
    this.staffId = staffId;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getState() {
    return this.state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getStaffName() {
    return this.staffName;
  }

  public void setStaffName(String staffName) {
    this.staffName = staffName;
  }

  public String getGender() {
    return this.gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public int getOrganizationId() {
    return this.organizationId;
  }

  public void setOrganizationId(int organizationId) {
    this.organizationId = organizationId;
  }

  public int getJobId() {
    return this.jobId;
  }

  public void setJobId(int jobId) {
    this.jobId = jobId;
  }

  public int getDirectBoss() {
    return directBoss;
  }

  public void setDirectBoss(int directBoss) {
    this.directBoss = directBoss;
  }

  public String getBirthplace() {
    return this.birthplace;
  }

  public void setBirthplace(String birthplace) {
    this.birthplace = birthplace;
  }

  public String getPosition() {
    return this.position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhotoUrl() {
    return this.photoUrl;
  }

  public void setPhotoUrl(String photoUrl) {
    this.photoUrl = photoUrl;
  }

  public Set<Askforleave> getAskforleave() {
    return this.askforleave;
  }

  public void setAskforleave(Set<Askforleave> askforleave) {
    this.askforleave = askforleave;
  }

  public Organization getOrganization() {
    return this.organization;
  }

  public void setOrganization(Organization organization) {
    this.organization = organization;
  }

  public Job getJob() {
    return this.job;
  }

  public void setJob(Job job) {
    this.job = job;
  }

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }
}
