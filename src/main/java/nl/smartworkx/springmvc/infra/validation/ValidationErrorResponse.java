package nl.smartworkx.springmvc.infra.validation;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: joris
 * Date: 3/22/13
 * Time: 7:53 AM
 */
public class ValidationErrorResponse {

    private final List<ValidationError> errors;

    public ValidationErrorResponse(MethodArgumentNotValidException exception) {
        errors = new ArrayList<ValidationError>();
        for(ObjectError error : exception.getBindingResult().getAllErrors()){
            errors.add(new ValidationError(error));
        }
    }

    public ValidationErrorResponse(HttpMessageNotReadableException exception) {
       errors = null;
    }

    public ValidationErrorResponse(ConstraintViolationException exception) {
        errors = new ArrayList<ValidationError>();
        for(ConstraintViolation violation : exception.getConstraintViolations()){
            errors.add(new ValidationError(violation));
        }
    }

    public List<ValidationError> getErrors(){
         return errors;
    }
}
