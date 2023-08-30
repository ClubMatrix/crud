package com.clubmatrix.crud.services;

import com.clubmatrix.crud.models.Employee;
import com.clubmatrix.crud.models.Login;
import com.clubmatrix.crud.models.Permission;
import com.clubmatrix.crud.repositories.EmployeeRepository;
import com.clubmatrix.crud.repositories.PermissionRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private PermissionRepository permissionRepository;

  public Employee registerEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  public void setPermissions(Long employeeId, List<String> permissions) {
    Employee employee = employeeRepository.findById(employeeId).orElse(null);
    if (employee == null) {
      throw new IllegalArgumentException("Employee not found with ID: " + employeeId);
    }

    Login login = employee.getLogin();

    login.getPermissions().clear();

    Set<Permission> fetchedPermissions = permissions.stream()
        .map((String slug) -> permissionRepository.findBySlug(slug))
        .collect(Collectors.toSet());

    login.getPermissions().addAll(fetchedPermissions);

    employeeRepository.save(employee);
  }
}
