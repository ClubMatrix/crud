package com.clubmatrix.crud.exceptions;

public class RecordNotFoundException extends DatabaseException {
  public RecordNotFoundException(String message) {
    super(message);
  }
}
