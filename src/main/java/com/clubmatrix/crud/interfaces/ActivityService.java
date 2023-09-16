package com.clubmatrix.crud.interfaces;

import com.clubmatrix.crud.interfaces.ServicesMethods.CreateService;
import com.clubmatrix.crud.interfaces.ServicesMethods.DeleteService;
import com.clubmatrix.crud.interfaces.ServicesMethods.ListService;
import com.clubmatrix.crud.interfaces.ServicesMethods.ReadService;
import com.clubmatrix.crud.interfaces.ServicesMethods.UpdateService;
import com.clubmatrix.crud.models.Activity;

public interface ActivityService extends CreateService<Activity>, DeleteService<Long>, ListService<Activity>,
        ReadService<Activity, Long>, UpdateService<Activity> {
}