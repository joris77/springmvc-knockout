package nl.smartworkx.springmvc.infra.app.template;

import nl.smartworkx.springmvc.infra.validation.ValidationError;

import java.util.List;

/**
 * Response for create person request
 */
public class CreateTemplateResponse {

    private Long id;

    public CreateTemplateResponse(Long id) {
        this.id = id;
    }

    public CreateTemplateResponse(List<ValidationError> allErrors) {
    }

    public Long getId() {
        return id;
    }
}
