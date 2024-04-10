package ro.tucn.erasmusbackend.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Interface that ensures that page size will be odd.
 */
public class OddPageSizeValidator implements ConstraintValidator<OddPageSize, Integer> {

    /**
     * Method that verifies if a page number is odd or even
     * @param value - page size (e.g. you are at page `value`)
     * @param context
     * @return boolean true (value is odd) or false (value is even)
     */
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value % 2 == 1;
    }
}
