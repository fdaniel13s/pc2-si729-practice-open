package biz.hotel.platform.u20221c628.sell.application.internal.queryServices;

import biz.hotel.platform.u20221c628.sell.domain.model.aggregates.Reservation;
import biz.hotel.platform.u20221c628.sell.domain.model.queries.GetReservationByGuestDniAndRoomIdQuery;
import biz.hotel.platform.u20221c628.sell.domain.model.queries.GetReservationByGuestNameAndRoomIdQuery;
import biz.hotel.platform.u20221c628.sell.domain.services.ReservationQueryService;
import biz.hotel.platform.u20221c628.sell.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationQueryServiceImpl implements ReservationQueryService {
    private final ReservationRepository reservationRepository;

    public ReservationQueryServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public Optional<Reservation> handle(GetReservationByGuestDniAndRoomIdQuery query) {
        return reservationRepository.findByGuestDniAndRoomId(query.guestDni(), query.roomId());
    }

    @Override
    public Optional<Reservation> handle(GetReservationByGuestNameAndRoomIdQuery query) {
        return reservationRepository.findByGuestNameAndRoomId(query.guestName(), query.roomId());
    }
}
