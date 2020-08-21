package com.example.spring.mvc.objects;

import com.example.spring.mvc.validation.CourseCode;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

    @Getter
    @Setter
    private String firstName;

    @Getter
    @Setter
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @Getter
    @Setter
    @NotNull(message = "is required")
    @Min(value = 0, message = "must be greater than or equal to 0")
    @Max(value = 10, message = "must be less than or equal to 10")
    private Integer freePasses;

    @Getter
    @Setter
    @Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 characters/digits")
    private String postalCode;

    @Getter
    @Setter
    @CourseCode(value="CAT", message="must start with CAT")
    private String courseCode;
}
