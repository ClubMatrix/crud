package com.clubmatrix.crud.interfaces;

import com.clubmatrix.crud.models.Activity;

public interface ActivityService extends CreateService<Activity>, DeleteService<Long>, ListService<Activity>,
        ReadService<Activity, Long>, UpdateService<Activity> {
}
