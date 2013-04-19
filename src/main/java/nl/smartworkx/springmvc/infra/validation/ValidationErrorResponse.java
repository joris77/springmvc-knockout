package nl.smartworkx.springmvc.infra.validation;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * User: joris
 * Date: 3/22/13
 * Time: 7:53 AM
 */
public class ValidationErrorResponse {

    private final ListMultimap<String, ValidationError> errors;

    private String globalError;

    public ValidationErrorResponse(MethodArgumentNotValidException exception) {
        errors = ArrayListMultimap.create();
        for(ObjectError error : exception.getBindingResult().getAllErrors()){
            errors.put(ValidationError.getKey(error), new ValidationError(error));
        }
    }

    public ValidationErrorResponse(HttpMessageNotReadableException exception) {
       errors = null;
        globalError = exception.getMessage();
    }

    public ValidationErrorResponse(ConstraintViolationException exception) {
        errors = ArrayListMultimap.create();
        for(ConstraintViolation violation : exception.getConstraintViolations()){
            errors.put(ValidationError.getKey(violation), new ValidationError(violation));
        }
    }

    public Map<String,Collection<ValidationError>> getErrors(){
         return errors == null ? null : errors.asMap();
    }

    public String getGlobalError() {
        return globalError;
    }
}
