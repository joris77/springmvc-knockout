package nl.smartworkx.springmvc.domain.account;

import nl.smartworkx.springmvc.infra.Aggregate;
import nl.smartworkx.springmvc.infra.DomainEntity;

import javax.persistence.Entity;

/**
 * User: joris
 * Date: 3/25/13
 * Time: 5:02 PM
 */
@Entity
public class Account extends DomainEntity {

    private String identification;

    public Account() {
    }

    public String getIdentification() {
        return identification;
    }
}
