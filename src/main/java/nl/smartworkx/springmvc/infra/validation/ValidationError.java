package nl.smartworkx.springmvc.infra.validation;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import javax.validation.ConstraintViolation;

/**
 * User: joris
 * Date: 3/20/13
 * Time: 5:11 PM
 */
public class ValidationError {
    private final String key;
    private final String message;

    public ValidationError(ConstraintViolation violation) {
        this.key = getKey(violation);
        this.message = violation.getMessage();
    }

    public static String getKey(ConstraintViolation violation) {
        return violation.getPropertyPath().toString();
    }

    public ValidationError(ObjectError error) {
        this.key = getKey(error);
        this.message = error.getDefaultMessage();
    }

    public static String getKey(ObjectError error) {
        if(error instanceof FieldError){
            return ((FieldError)error).getField();
        }else{
             return error.getObjectName();
        }
    }

    public String getKey(){
        return key;
    }

    public String getMessage(){
        return message;
    }
}
