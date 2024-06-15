package biz.hotel.platform.u20221c628.sell.domain.services;

import biz.hotel.platform.u20221c628.sell.domain.model.aggregates.Reservation;
import biz.hotel.platform.u20221c628.sell.domain.model.queries.GetReservationByGuestDniAndRoomIdQuery;
import biz.hotel.platform.u20221c628.sell.domain.model.queries.GetReservationByGuestNameAndRoomIdQuery;

import java.util.Optional;

public interface ReservationQueryService {

    Optional<Reservation> handle(GetReservationByGuestDniAndRoomIdQuery query);

    Optional<Reservation> handle(GetReservationByGuestNameAndRoomIdQuery query);

}
