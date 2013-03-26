package nl.smartworkx.springmvc.infra.app.template;

import nl.smartworkx.springmvc.domain.template.*;
import nl.smartworkx.springmvc.infra.app.BaseController;
import nl.smartworkx.springmvc.infra.app.OkResponse;
import nl.smartworkx.springmvc.infra.validation.ValidationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * User: joris
 * Date: 3/7/13
 * Time: 8:53 PM
 */
@Controller
@RequestMapping(value = "/templates")
public class TemplateController extends BaseController {

    public static final String APPLICATION_JSON = "application/json";

    private static Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    @Autowired
    private CreateTemplateService createPersonService;


    @Autowired
    private EditTemplateService editTemplateService;

    /**
     * Returns a person by id.
     *
     * @param id of the person.
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Template findPersonById(@PathVariable("id") Long id) {
        LOGGER.debug("Find");
        return null;
    }

    /**
     * Creates a person.
     *
     * @param command to create.
     * @return response with id of the created person or validation messages.
     */
    @RequestMapping(method = RequestMethod.POST, consumes="application/json", produces="application/json")
    @ResponseBody
    public CreateTemplateResponse create(@RequestBody @Valid CreateTemplateCommand command) {
        LOGGER.debug("Creating " + command);

        final Template template = createPersonService.create(command);

        return new CreateTemplateResponse(template.getId());

    }

    /**
     * Creates a person.
     *
     * @param command to create.
     * @return response with id of the created person or validation messages.
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public OkResponse edit(@PathVariable("id") Long id, @Valid @RequestBody EditTemplateCommand command) throws ValidationException {
        LOGGER.debug("Editing " + command);

        command.setId(id);
        editTemplateService.edit(command);

        return new OkResponse();
    }
}
