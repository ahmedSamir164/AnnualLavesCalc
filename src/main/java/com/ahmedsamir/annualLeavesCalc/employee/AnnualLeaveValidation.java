package com.ahmedsamir.annualLeavesCalc.employee;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AnnualLeaveValidator.class)
@Documented

public @interface AnnualLeaveValidation {
    String message() default "the annual leave is rejected due to not having enough balance";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
} 