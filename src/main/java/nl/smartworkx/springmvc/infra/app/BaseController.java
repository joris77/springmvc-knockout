package nl.smartworkx.springmvc.infra.app;

import nl.smartworkx.springmvc.infra.validation.ValidationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

/**
 * User: joris
 * Date: 3/22/13
 * Time: 7:51 AM
 */
public class BaseController {

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handle(MethodArgumentNotValidException exception){
        return new ValidationErrorResponse(exception);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handle(HttpMessageNotReadableException exception){
        return new ValidationErrorResponse(exception);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ValidationErrorResponse handle(ConstraintViolationException exception){
        return new ValidationErrorResponse(exception);
    }
}
