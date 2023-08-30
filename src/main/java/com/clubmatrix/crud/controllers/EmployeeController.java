package com.clubmatrix.crud.controllers;

import com.clubmatrix.crud.models.Employee;
import com.clubmatrix.crud.services.EmployeeService;
import com.clubmatrix.crud.utils.AuthUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @Autowired
  private AuthUtil authUtil;

  @PostMapping
  public ResponseEntity<?> registerEmployee(@RequestBody Employee employee, HttpServletRequest request) {
    String token = request.getHeader("Authorization").split(" ")[1];
    if (!authUtil.hasPermission(token, "manage_employees")) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Permission denied.");
    }

    Employee registeredEmployee = employeeService.registerEmployee(employee);
    return ResponseEntity.status(HttpStatus.CREATED).body(registeredEmployee);
  }

  @PostMapping("/{employeeId}/permissions")
  public ResponseEntity<?> setPermissions(@PathVariable Long employeeId, @RequestBody List<String> permissions,
      HttpServletRequest request) {
    String token = request.getHeader("Authorization").split(" ")[1];
    if (!authUtil.hasPermission(token, "set_permissions")) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Permission denied.");
    }

    employeeService.setPermissions(employeeId, permissions);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
