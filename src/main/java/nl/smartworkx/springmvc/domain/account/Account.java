package nl.smartworkx.springmvc.domain.account;

import nl.smartworkx.springmvc.infra.Aggregate;
import nl.smartworkx.springmvc.infra.DomainEntity;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;

/**
 * User: joris
 * Date: 3/25/13
 * Time: 5:02 PM
 */
@Entity
public class Account extends DomainEntity {

    @NotEmpty
    private String identification;

    Account() {
    }

    public Account(String identification) {
        this.identification = identification;
    }

    public String getIdentification() {
        return identification;
    }

    @Override
    public String toString() {
        return identification;
    }
}