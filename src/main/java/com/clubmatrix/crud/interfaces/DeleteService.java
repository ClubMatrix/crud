package com.clubmatrix.crud.interfaces;

public interface DeleteService<Id> {
  void delete(Id id);

  void restore(Id id);
}
