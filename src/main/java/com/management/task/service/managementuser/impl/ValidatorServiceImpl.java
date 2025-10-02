package com.management.task.service.managementuser.impl;

import com.management.task.service.managementuser.ValidatorService;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.validation.Validator;
import jakarta.validation.ConstraintViolation;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class ValidatorServiceImpl implements ValidatorService {

    private final Validator validator;

    @Override
    public void validator(Object request){
        Set<ConstraintViolation<Object>> constraintViolations = validator.validate(request);
        if (!constraintViolations.isEmpty()){
            throw new ConstraintViolationException(constraintViolations);
        }

    }
}
