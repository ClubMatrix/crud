package com.clubmatrix.crud.repositories;

import com.clubmatrix.crud.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
  public Permission findBySlug(String slug);
}
