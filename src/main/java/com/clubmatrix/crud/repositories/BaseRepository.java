package com.clubmatrix.crud.repositories;

import com.clubmatrix.crud.models.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseRepository<T extends BaseModel> extends JpaRepository<T, Long> {
  Optional<T> findByIdAndDeletedAtIsNull(Long id);
}
