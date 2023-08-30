package com.clubmatrix.crud.controllers;

import com.clubmatrix.crud.models.Activity;
import com.clubmatrix.crud.services.ActivityService;
import com.clubmatrix.crud.utils.AuthUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/activities")
public class ActivityController {

  @Autowired
  private ActivityService activityService;

  @Autowired
  private AuthUtil authUtil;

  @PostMapping
  public ResponseEntity<?> registerActivity(@RequestBody Activity activity, HttpServletRequest request) {
    String token = request.getHeader("Authorization").split(" ")[1];
    if (!authUtil.hasPermission(token, "register_activity")) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Permission denied.");
    }

    Activity registeredActivity = activityService.registerActivity(activity);
    return ResponseEntity.status(HttpStatus.CREATED).body(registeredActivity);
  }

  @GetMapping
  public ResponseEntity<?> getAllActivities(HttpServletRequest request) {
    String token = request.getHeader("Authorization").split(" ")[1];
    if (!authUtil.hasPermission(token, "view_activities")) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Permission denied.");
    }

    List<Activity> activities = activityService.getAllActivities();
    return ResponseEntity.ok(activities);
  }
}
