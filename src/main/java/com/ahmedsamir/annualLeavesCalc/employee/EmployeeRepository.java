package com.ahmedsamir.annualLeavesCalc.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository <Employee , Integer> {
    List<Employee> findByNameContaining(String name);
    Employee findByName(String name);
}
