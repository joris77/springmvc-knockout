package nl.smartworkx.springmvc.infra.service;

import nl.smartworkx.springmvc.infra.events.EventBusService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * User: joris
 * Date: 3/22/13
 * Time: 1:25 PM
 */
public class BaseService {

    @Autowired
    protected EventBusService eventBusService;
}
