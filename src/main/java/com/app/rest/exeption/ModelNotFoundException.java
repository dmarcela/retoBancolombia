package com.app.rest.exeption;

public class ModelNotFoundException extends RuntimeException{
  public ModelNotFoundException(String messageError){
    super(messageError);
  }
}
