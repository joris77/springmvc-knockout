package nl.smartworkx.springmvc.domain.template;

import javax.validation.constraints.Min;

/**
 * User: joris
 * Date: 3/22/13
 * Time: 12:42 PM
 */
public class EditTemplateCommand {

    private Long id;

    private String name;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}
