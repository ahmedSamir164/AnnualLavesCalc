package com.ahmedsamir.annualLeavesCalc.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        employeeRepository.save(new Employee("ahmed samir" , 30));
        employeeRepository.save(new Employee("eslam samir" , 30));
        employeeRepository.save(new Employee("Haggag Ali" , 30));
        employeeRepository.save(new Employee("Salah naser" , 30));
        employeeRepository.save(new Employee("adel sobhy" , 30));
        employeeRepository.save(new Employee("ahmed adel" , 30));
        employeeRepository.save(new Employee("adel ahmed" , 30));
    }

}
