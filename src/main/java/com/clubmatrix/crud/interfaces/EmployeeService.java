package com.clubmatrix.crud.interfaces;

import com.clubmatrix.crud.interfaces.ServicesMethods.CreateService;
import com.clubmatrix.crud.interfaces.ServicesMethods.DeleteService;
import com.clubmatrix.crud.interfaces.ServicesMethods.ListService;
import com.clubmatrix.crud.interfaces.ServicesMethods.ReadService;
import com.clubmatrix.crud.interfaces.ServicesMethods.UpdateService;
import com.clubmatrix.crud.models.Employee;

public interface EmployeeService extends CreateService<Employee>, DeleteService<Long>, ListService<Employee>,
        ReadService<Employee, Long>, UpdateService<Employee> {
}