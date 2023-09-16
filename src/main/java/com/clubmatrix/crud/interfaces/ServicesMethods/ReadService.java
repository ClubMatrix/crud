package com.clubmatrix.crud.interfaces.ServicesMethods;

public interface ReadService<T, Id> {
  T read(Id id);
}
