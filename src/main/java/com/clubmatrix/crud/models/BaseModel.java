package com.clubmatrix.crud.models;

import jakarta.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Date createdAt;
  private Date updatedAt;
  private Date deletedAt;

  public Long getId() {
    return id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public Date getUpdatedAt() {
    return updatedAt;
  }

  public Date getDeletedAt() {
    return deletedAt;
  }

  public void setDeletedAt() {
    this.deletedAt = new Date();
  }

  public void unsetDeletedAt() {
    this.deletedAt = null;
  }

  @PrePersist
  public void prePersist() {
    this.createdAt = new Date();
    this.updatedAt = new Date();
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = new Date();
  }
}
