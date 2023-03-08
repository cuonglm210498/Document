package com.vss.springbootkeycloak.service;

import com.vss.springbootkeycloak.entity.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getEmployee(int employeeId);

    List<Employee> getAllEmployees();
}
