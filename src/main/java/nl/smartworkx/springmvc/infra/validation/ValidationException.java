package nl.smartworkx.springmvc.infra.validation;

import javax.validation.ConstraintViolation;
import java.util.Set;

/**
 * User: joris
 * Date: 3/20/13
 * Time: 5:13 PM
 */
public class ValidationException extends Exception{
    private Set<ConstraintViolation> errors;

    public ValidationException(Set<ConstraintViolation> errors) {
        this.errors = errors;
    }

    public Set<ConstraintViolation> getErrors() {
        return errors;
    }
}
