package nl.smartworkx.springmvc.domain.template;

import javax.validation.constraints.Min;

/**
 * User: joris
 * Date: 3/20/13
 * Time: 8:51 AM
 */
public class CreateTemplateCommand {

    private String name;


    public void setName(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "CreateTemplateCommand{" +
                "name='" + name + '\'' +
                '}';
    }
}
