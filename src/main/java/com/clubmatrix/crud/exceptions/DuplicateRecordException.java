package com.clubmatrix.crud.exceptions;

public class DuplicateRecordException extends DatabaseException {
  public DuplicateRecordException(String message) {
    super(message);
  }
}
