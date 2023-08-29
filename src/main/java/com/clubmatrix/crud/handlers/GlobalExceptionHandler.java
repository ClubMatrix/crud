package com.clubmatrix.crud.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.clubmatrix.crud.exceptions.AppException;
import com.clubmatrix.crud.exceptions.AuthenticationFailedException;
import com.clubmatrix.crud.exceptions.DatabaseException;
import com.clubmatrix.crud.exceptions.DuplicateRecordException;
import com.clubmatrix.crud.exceptions.RecordNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(DatabaseException.class)
  public ResponseEntity<String> handleDatabaseException(DatabaseException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(AuthenticationFailedException.class)
  public ResponseEntity<String> handleAuthenticationFailed(AuthenticationFailedException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler(RecordNotFoundException.class)
  public ResponseEntity<String> handleRecordNotFound(RecordNotFoundException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DuplicateRecordException.class)
  public ResponseEntity<String> handleDuplicateRecord(DuplicateRecordException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
  }

  @ExceptionHandler(AppException.class)
  public ResponseEntity<String> handleAppException(AppException e) {
    return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleGenericException(Exception e) {
    return new ResponseEntity<>("Internal server error.", HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
