package biz.hotel.platform.u20221c628.sell.domain.services;

import biz.hotel.platform.u20221c628.sell.domain.model.aggregates.Reservation;
import biz.hotel.platform.u20221c628.sell.domain.model.commands.CreateReservationCommand;

import java.util.Optional;


public interface ReservationCommandService {
    Optional<Reservation> handle(CreateReservationCommand createReservationCommand);
}
