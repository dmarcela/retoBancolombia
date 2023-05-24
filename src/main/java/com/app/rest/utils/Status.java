package com.app.rest.utils;

public enum Status {
  EXITOSO("EXITOSO"),
  FALLIDO("FALLIDO");

  private final String status;

  Status(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }
}
