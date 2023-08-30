package com.clubmatrix.crud.repositories;

import com.clubmatrix.crud.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
