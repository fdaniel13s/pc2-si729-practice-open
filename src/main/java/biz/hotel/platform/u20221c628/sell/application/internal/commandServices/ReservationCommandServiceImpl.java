package biz.hotel.platform.u20221c628.sell.application.internal.commandServices;

import biz.hotel.platform.u20221c628.sell.domain.model.aggregates.Reservation;
import biz.hotel.platform.u20221c628.sell.domain.model.commands.CreateReservationCommand;
import biz.hotel.platform.u20221c628.sell.domain.services.ReservationCommandService;
import biz.hotel.platform.u20221c628.sell.infrastructure.persistence.jpa.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReservationCommandServiceImpl implements ReservationCommandService {

    private final ReservationRepository reservationRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Optional<Reservation> handle(CreateReservationCommand command) {
        if (!isGuestNameAndRoomIdUnique(command.guestName(), command.roomId()))
            throw new IllegalArgumentException("Guest name and room id combination already exists");

        if (!isGuestDniAndRoomIdUnique(command.guestDni(), command.roomId()))
            throw new IllegalArgumentException("Guest dni and room id combination already exists");

        try {
            var reservation = new Reservation(command);
            reservationRepository.save(reservation);
            return Optional.of(reservation);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving reservation");
        }
    }



    /**
     * Business rule: It is not allowed with the combination of guestName and id
     */
    private boolean isGuestNameAndRoomIdUnique(String guestName, Integer roomId) {
        return reservationRepository.findByGuestNameAndRoomId(guestName, roomId).isEmpty();
    }

    /**
     * Business rule: It is not allowed with the combination of guestDni and id
     */
    private boolean isGuestDniAndRoomIdUnique(String guestDni, Integer roomId) {
        return reservationRepository.findByGuestDniAndRoomId(guestDni, roomId).isEmpty();
    }
}
