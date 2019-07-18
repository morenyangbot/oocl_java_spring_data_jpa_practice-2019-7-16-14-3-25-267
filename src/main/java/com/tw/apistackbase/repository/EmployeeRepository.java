package com.tw.apistackbase.repository;

import com.tw.apistackbase.core.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
