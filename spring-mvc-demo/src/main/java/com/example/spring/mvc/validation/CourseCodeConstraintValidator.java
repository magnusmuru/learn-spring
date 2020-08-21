package com.example.spring.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

    private String coursePrefix;

    @Override
    public void initialize(CourseCode courseCode) {
        coursePrefix = courseCode.value();
    }

    @Override
    public boolean isValid(String userInput, ConstraintValidatorContext context) {
        boolean result;

        if (userInput != null) {
            result = userInput.startsWith(coursePrefix);
        } else {
            result = true;
        }
        return result;
    }
}
