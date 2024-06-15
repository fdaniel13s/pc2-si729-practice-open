package biz.hotel.platform.u20221c628.sell.domain.model.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * Event that represents a reservation created.
 * <p> Practice events in DDD. </p>
 * Represents that a reservation and the functionality is that it is created.
 * The event is used to notify the system that a reservation has been created.
 * @see ReservationCreatedEvent
 * @see ApplicationEvent
 */

@Getter
public final class ReservationCreatedEvent extends ApplicationEvent {

    private final Long reservationId;


    /**
     * Constructor of the event.
     * <p>The super allow get the object that published the event.</p>
     * @param source The source the published the event.
     * @param reservationId The id of the reservation.
     */
    public ReservationCreatedEvent(Object source, Long reservationId) {
        super(source);
        this.reservationId = reservationId;
    }
}
