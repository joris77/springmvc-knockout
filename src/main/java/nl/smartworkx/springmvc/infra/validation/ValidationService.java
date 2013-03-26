package nl.smartworkx.springmvc.infra.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

/**
 * User: joris
 * Date: 3/21/13
 * Time: 7:45 AM
 */
@Service
public class ValidationService {

    @Autowired
    private Validator validator;

    public void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);

        if(!violations.isEmpty()) {
            throw new ConstraintViolationException(new HashSet<ConstraintViolation<?>>(violations));
        }
    }
}
