package nl.smartworkx.springmvc.infra.app.account;

import nl.smartworkx.springmvc.domain.account.Account;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

/**
 * User: joris
 * Date: 4/19/13
 * Time: 9:13 AM
 */
public class StringToAccountConverter implements Converter<String, Account> {
    @Override
    public Account convert(String source) {
        if (StringUtils.hasText(source)) {
            return new Account(source);
        }
        return null;
    }
}
