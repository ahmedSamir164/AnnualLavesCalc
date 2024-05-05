package com.ahmedsamir.annualLeavesCalc.employee;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@Service
@Validated
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getEmployees(String name) {
        List<Employee> employees= employeeRepository.findByNameContaining(name);
        return employees;
    }

    public Employee getEmployee(String name) {
        Employee employee= employeeRepository.findByName(name);
        return employee;
    }

    public int calculateDaysBetweenExcludingWeekends(LocalDate startDate, LocalDate endDate) {
        int daysBetween = 0;
        LocalDate currentDate = startDate;
        
        while (!currentDate.isAfter(endDate)) {
            if (currentDate.getDayOfWeek().getValue() != 5 && currentDate.getDayOfWeek().getValue() != 6) {
                daysBetween++;
            }
            currentDate = currentDate.plusDays(1);
        }
        
        return daysBetween;
    }

    public Employee submitAnnualLeave(String name,@Valid Employee updatedEmployee) {
        Employee employee = employeeRepository.findByName(name);

        int leavedays = calculateDaysBetweenExcludingWeekends
        (updatedEmployee.getLeave_start(), updatedEmployee.getLeave_end());

        employee.setLeaves_balance( employee.getLeaves_balance()-leavedays);

        if (employee.getLeaves_balance() < 0){
            throw new IllegalArgumentException("Invalid annual leave duration");
        }

        return employeeRepository.save(employee);
    }
}
