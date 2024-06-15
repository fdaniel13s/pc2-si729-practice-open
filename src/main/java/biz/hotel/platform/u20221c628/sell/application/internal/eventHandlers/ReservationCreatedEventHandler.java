package biz.hotel.platform.u20221c628.sell.application.internal.eventHandlers;

import biz.hotel.platform.u20221c628.sell.domain.model.events.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
public class ReservationCreatedEventHandler {

    /**
     * Method that listen the event of reservation created.
     * @param event The event that is listened.
     * We should see the event in the console.
     */
    @EventListener(ReservationCreatedEvent.class)
    public void on(ReservationCreatedEvent event){
        //Here we should implement the logic to handle the event.
        System.out.println("Reservation created: " + event.getReservationId());
    }
}
