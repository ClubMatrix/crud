package com.clubmatrix.crud.interfaces;

public interface ReadService<T, Id> {
  T read(Id id);
}
