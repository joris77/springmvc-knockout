package nl.smartworkx.springmvc.infra.events;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.Subscribe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: joris
 * Date: 3/24/13
 * Time: 12:16 AM
 */
public class LogEventListener {

    private static Logger LOGGER = LoggerFactory.getLogger(LogEventListener.class);

    @Subscribe
    @AllowConcurrentEvents
    public void handle(Object object){
        LOGGER.info("Event {} is published.", object);
    }
}
