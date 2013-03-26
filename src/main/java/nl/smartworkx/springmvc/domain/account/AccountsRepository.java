package nl.smartworkx.springmvc.domain.account;

import nl.smartworkx.springmvc.infra.repository.BaseRepository;

/**
 * User: joris
 * Date: 3/25/13
 * Time: 5:12 PM
 */
public class AccountsRepository extends BaseRepository<Account>{
    @Override
    public Class<Account> getDomainClass() {
        return Account.class;
    }
}
