package com.clubmatrix.crud.services;

import com.clubmatrix.crud.models.BaseModel;
import com.clubmatrix.crud.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class BaseService<T extends BaseModel> {
  @Autowired
  private BaseRepository<T> repository;

  @Transactional
  public T create(T entity) {
    return repository.save(entity);
  }

  public Optional<T> read(Long id) {
    return repository.findByIdAndDeletedAtIsNull(id);
  }

  @Transactional
  public Optional<T> update(T entity) {
    if (repository.existsById(entity.getId())) {
      return Optional.of(repository.save(entity));
    }
    return Optional.empty();
  }

  @Transactional
  public void delete(Long id) {
    Optional<T> entityOpt = repository.findById(id);
    entityOpt.ifPresent(entity -> {
      entity.setDeletedAt();
      repository.save(entity);
    });
  }

  @Transactional
  public void restore(Long id) {
    Optional<T> entityOpt = repository.findById(id);
    entityOpt.ifPresent(entity -> {
      entity.unsetDeletedAt();
      repository.save(entity);
    });
  }
}
