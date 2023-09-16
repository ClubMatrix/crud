package com.clubmatrix.crud.services;

import com.clubmatrix.crud.interfaces.FeedbackService;
import com.clubmatrix.crud.models.Feedback;
import com.clubmatrix.crud.repositories.FeedbackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

  @Autowired
  private FeedbackRepository feedbackRepository;

  @Override
  public Feedback create(Feedback feedback) {
    return feedbackRepository.save(feedback);
  }

  @Override
  public void delete(Long id) {
    Optional<Feedback> feedbackOpt = feedbackRepository.findById(id);
    if (feedbackOpt.isPresent()) {
      Feedback feedback = feedbackOpt.get();
      feedback.setDeletedAt();
      feedbackRepository.save(feedback);
    }
  }

  @Override
  public void restore(Long id) {
    Optional<Feedback> feedbackOpt = feedbackRepository.findById(id);
    if (feedbackOpt.isPresent()) {
      Feedback feedback = feedbackOpt.get();
      feedback.unsetDeletedAt();
      feedbackRepository.save(feedback);
    }
  }

  @Override
  public ArrayList<Feedback> list(Map<String, Object> filters, Map<String, String> sort, int page, int size) {
    // TODO: Implement filters

    List<Feedback> activities = feedbackRepository.findAll();
    return new ArrayList<>(activities);
  }

  @Override
  public Feedback read(Long id) {
    Optional<Feedback> feedback = feedbackRepository.findById(id);
    return feedback.orElse(null);
  }

  @Override
  public Feedback update(Feedback feedback) {
    if (feedbackRepository.existsById(feedback.getId())) {
      return feedbackRepository.save(feedback);
    }
    return null;
  }
}
