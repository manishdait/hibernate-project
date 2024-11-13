package com.example;

import javax.persistence.Embeddable;

// import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
  private String buildName;
  private String street;
  private String planet;

  public Address() {}

  public Address(String buildName, String street, String planet) {
    this.buildName = buildName;
    this.street = street;
    this.planet = planet;
  }

  public String getBuildName() {
    return buildName;
  }

  public void setBuildName(String buildName) {
    this.buildName = buildName;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getPlanet() {
    return planet;
  }

  public void setPlanet(String planet) {
    this.planet = planet;
  }
}
