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
        this.key = violation.getPropertyPath().toString();
        this.message = violation.getMessage();
    }

    public ValidationError(ObjectError error) {
        if(error instanceof FieldError){
            this.key = ((FieldError)error).getField();
        }else{
             this.key = error.getObjectName();
        }
        this.message = error.getDefaultMessage();
    }

    public String getKey(){
        return key;
    }

    public String getMessage(){
        return message;
    }
}
