package com.clubmatrix.crud.repositories;

import com.clubmatrix.crud.models.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}