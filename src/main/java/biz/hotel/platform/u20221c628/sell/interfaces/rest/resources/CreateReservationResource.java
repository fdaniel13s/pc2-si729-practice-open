package biz.hotel.platform.u20221c628.sell.interfaces.rest.resources;

import java.util.Date;

public record CreateReservationResource(
        String guestName,
        String guestDni,
        String guestEmail,
        Integer roomId,
        String roomName,
        String roomType,
        Date startDate,
        Date endDate,
        Float price,
        Float discountPercent) {
}
