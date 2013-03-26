package nl.smartworkx.springmvc.infra.events;

import com.google.common.eventbus.EventBus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * User: joris
 * Date: 3/23/13
 * Time: 10:49 PM
 */
@Service
public class EventBusService {

    private static Logger LOGGER = LoggerFactory.getLogger(EventBusService.class);

    private EventBus eventBus = new EventBus();

    public EventBusService(){
        eventBus.register(new LogEventListener());
    }


    public void publish(Object event){
        eventBus.post(event);
    }
}
