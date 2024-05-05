package com.ahmedsamir.annualLeavesCalc.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.FutureOrPresent;

import java.time.LocalDate;
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "increment")
    @SequenceGenerator(name = "increment", allocationSize = 1)
    private int id;
    private String name;
    private int leaves_balance;
    @FutureOrPresent(message = "selected date must be in the future")
    private LocalDate leave_start;
    @FutureOrPresent(message = "selected date must be in the future")
    private LocalDate leave_end;


    public Employee() {
    }

    

    public Employee(LocalDate leave_start, LocalDate leave_end) {
        this.leave_start = leave_start;
        this.leave_end = leave_end;
    }

    public Employee( String name, int leaves_balance, LocalDate leave_start, LocalDate leave_end) {
        this.name = name;
        this.leaves_balance = leaves_balance;
        this.leave_start = leave_start;
        this.leave_end = leave_end;
    }
    

    public Employee(String name, int leaves_balance) {
        this.name = name;
        this.leaves_balance = leaves_balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLeaves_balance() {
        return leaves_balance;
    }

    public void setLeaves_balance(int leaves_balance) {
        this.leaves_balance = leaves_balance;
    }

    public LocalDate getLeave_start() {
        return leave_start;
    }

    public void setLeave_start(LocalDate leave_start) {
        this.leave_start = leave_start;
    }

    public LocalDate getLeave_end() {
        return leave_end;
    }

    public void setLeave_end(LocalDate leave_end) {
        this.leave_end = leave_end;
    }
}
