package nl.smartworkx.springmvc.infra;

import javax.persistence.*;

/**
 * User: joris
 * Date: 3/23/13
 * Time: 12:20 PM
 */
@MappedSuperclass
public class Aggregate extends DomainEntity{

    @Version
    private Long versionNumber;

    public Long getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Long versionNumber) {
        this.versionNumber = versionNumber;
    }
}
