package com.clubmatrix.crud.services;

import com.clubmatrix.crud.interfaces.ActivityService;
import com.clubmatrix.crud.models.Activity;
import com.clubmatrix.crud.repositories.ActivityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ActivityServiceImpl implements ActivityService {

  @Autowired
  private ActivityRepository activityRepository;

  @Override
  public Activity create(Activity activity) {
    return activityRepository.save(activity);
  }

  @Override
  public void delete(Long id) {
    Optional<Activity> activityOpt = activityRepository.findById(id);
    if (activityOpt.isPresent()) {
      Activity activity = activityOpt.get();
      activity.setDeletedAt();
      activityRepository.save(activity);
    }
  }

  @Override
  public void restore(Long id) {
    Optional<Activity> activityOpt = activityRepository.findById(id);
    if (activityOpt.isPresent()) {
      Activity activity = activityOpt.get();
      activity.unsetDeletedAt();
      activityRepository.save(activity);
    }
  }

  @Override
  public ArrayList<Activity> list(Map<String, Object> filters, Map<String, String> sort, int page, int size) {
    // TODO: Implement filters

    List<Activity> activities = activityRepository.findAll();
    return new ArrayList<>(activities);
  }

  @Override
  public Activity read(Long id) {
    Optional<Activity> activity = activityRepository.findById(id);
    return activity.orElse(null);
  }

  @Override
  public Activity update(Activity activity) {
    if (activityRepository.existsById(activity.getId())) {
      return activityRepository.save(activity);
    }
    return null;
  }
}