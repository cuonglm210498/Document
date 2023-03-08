package com.vss.springbootkeycloak.controller;

import com.vss.springbootkeycloak.entity.Employee;
import com.vss.springbootkeycloak.service.EmployeeService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Data
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    @RolesAllowed("user")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) {
        return ResponseEntity.ok(employeeService.getEmployee(employeeId));
    }

    //this method can be accessed by user whose role is admin
    @GetMapping
    @RolesAllowed("admin")
    public ResponseEntity<List<Employee>> findALlEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }
}
