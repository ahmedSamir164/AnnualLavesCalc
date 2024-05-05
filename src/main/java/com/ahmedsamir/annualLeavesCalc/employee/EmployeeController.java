package com.ahmedsamir.annualLeavesCalc.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees/{name}")
    public List<Employee> getEmployees(@PathVariable("name") String name) {
      return employeeService.getEmployees(name);
    }

    
    @GetMapping("/employee/{name}")
    public Employee getEmployee(@PathVariable("name") String name) {
      return employeeService.getEmployee(name);
    }

    @PutMapping("/submit/{name}")
    public Employee submitAnnualLeave(@PathVariable String name, @Valid @RequestBody Employee updatedEmployee) {
        Employee employee = employeeService.submitAnnualLeave(name, updatedEmployee);
        return employee;
    }
    
}
