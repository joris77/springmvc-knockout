package nl.smartworkx.springmvc.domain.template;

import nl.smartworkx.springmvc.infra.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.rowset.spi.TransactionalWriter;
import javax.validation.Valid;

/**
 * User: joris
 * Date: 3/20/13
 * Time: 5:14 PM
 */
@Service
@Transactional
public class CreateTemplateService extends BaseService {

    @Autowired
    private TemplatesRepository repository;

    public Template create(@Valid CreateTemplateCommand command) {
        Template template = new Template(command);

        repository.create(template);

        eventBusService.publish(command);

        return template;
    }
}
