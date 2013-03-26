package nl.smartworkx.springmvc.domain.template;

import nl.smartworkx.springmvc.infra.service.BaseService;
import nl.smartworkx.springmvc.infra.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * User: joris
 * Date: 3/22/13
 * Time: 12:53 PM
 */
@Service
@Transactional
public class EditTemplateService extends BaseService{

    @Autowired
    private TemplatesRepository repository;


    public void edit(EditTemplateCommand command) throws ValidationException {
        Template template = repository.findById(command.getId());
        template.edit(command);
        repository.update(template);

        eventBusService.publish(command);
    }
}
