package nl.smartworkx.springmvc.domain.template;

import nl.smartworkx.springmvc.domain.account.Account;
import nl.smartworkx.springmvc.infra.Aggregate;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * User: joris
 * Date: 3/7/13
 * Time: 9:04 PM
 */
@Entity
public class Template extends Aggregate {

    @NotEmpty
    @Length(max = 50)
    private String name;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    private Account account;

    Template(){}

    public Template(CreateTemplateCommand command) {
        this.name = command.getName();
        this.account = command.getAccount();
    }

    public void edit(EditTemplateCommand command) {
        this.name = command.getName();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Template{" +
                "name='" + name + '\'' +
                '}';
    }


}
