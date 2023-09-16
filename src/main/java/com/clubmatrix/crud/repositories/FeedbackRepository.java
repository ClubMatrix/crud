package com.clubmatrix.crud.repositories;

import com.clubmatrix.crud.models.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
