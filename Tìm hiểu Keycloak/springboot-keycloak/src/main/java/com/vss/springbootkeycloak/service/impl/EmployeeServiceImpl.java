package com.vss.springbootkeycloak.service.impl;

import com.vss.springbootkeycloak.entity.Employee;
import com.vss.springbootkeycloak.repository.EmployeeRepository;
import com.vss.springbootkeycloak.service.EmployeeService;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void initializeEmployeeTable() {
        employeeRepository.saveAll(
                Stream.of(
                        new Employee("john", 20000),
                        new Employee("mak", 55000),
                        new Employee("peter", 120000)
                ).collect(Collectors.toList()));
    }

    public Employee getEmployee(int employeeId) {
        return employeeRepository
                .findById(employeeId)
                .orElse(null);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository
                .findAll();
    }
}
