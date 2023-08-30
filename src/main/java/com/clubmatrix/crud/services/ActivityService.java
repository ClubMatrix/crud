package com.clubmatrix.crud.services;

import com.clubmatrix.crud.models.Activity;
import com.clubmatrix.crud.repositories.ActivityRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

  @Autowired
  private ActivityRepository activityRepository;

  public Activity registerActivity(Activity activity) {
    return activityRepository.save(activity);
  }

  public List<Activity> getAllActivities() {
    return activityRepository.findAll();
  }
}
