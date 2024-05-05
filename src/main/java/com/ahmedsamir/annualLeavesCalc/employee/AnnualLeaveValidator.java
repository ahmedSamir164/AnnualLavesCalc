package com.ahmedsamir.annualLeavesCalc.employee;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AnnualLeaveValidator implements ConstraintValidator<AnnualLeaveValidation, Integer> {

    @Override
    public boolean isValid(Integer arg0, ConstraintValidatorContext arg1) {

        return arg0 >=0;
    }

}
