package com.clubmatrix.crud.interfaces.ServicesMethods;

public interface DeleteService<Id> {
  void delete(Id id);

  void restore(Id id);
}
