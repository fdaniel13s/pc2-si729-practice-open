package biz.hotel.platform.u20221c628.sell.infrastructure.persistence.jpa.repositories;

import biz.hotel.platform.u20221c628.sell.domain.model.aggregates.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    Optional<Reservation> findByGuestDniAndRoomId(String guestDni, Integer roomId);

    Optional<Reservation> findByGuestNameAndRoomId(String guestName, Integer roomId);


}
