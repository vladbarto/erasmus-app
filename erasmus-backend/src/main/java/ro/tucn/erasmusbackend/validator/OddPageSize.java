package ro.tucn.erasmusbackend.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = OddPageSizeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/**
 * Interface that promises that page size will be odd.
 */
public @interface OddPageSize {

    String message() default "Page size must be an odd number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
