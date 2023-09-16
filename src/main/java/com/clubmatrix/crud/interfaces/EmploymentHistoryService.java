package com.clubmatrix.crud.interfaces;

import com.clubmatrix.crud.interfaces.ServicesMethods.CreateService;
import com.clubmatrix.crud.interfaces.ServicesMethods.DeleteService;
import com.clubmatrix.crud.interfaces.ServicesMethods.ListService;
import com.clubmatrix.crud.interfaces.ServicesMethods.ReadService;
import com.clubmatrix.crud.interfaces.ServicesMethods.UpdateService;
import com.clubmatrix.crud.models.EmploymentHistory;

public interface EmploymentHistoryService extends CreateService<EmploymentHistory>, DeleteService<Long>, ListService<EmploymentHistory>,
        ReadService<EmploymentHistory, Long>, UpdateService<EmploymentHistory> {
}