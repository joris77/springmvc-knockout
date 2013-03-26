package nl.smartworkx.springmvc.infra;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * User: joris
 * Date: 3/25/13
 * Time: 5:06 PM
 */
@MappedSuperclass
public class DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
