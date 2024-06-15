package biz.hotel.platform.u20221c628.sell.domain.model.commands;

import java.util.Date;

public record CreateReservationCommand(String guestDni, String guestName, String guestEmail,
                                       Integer roomId, String roomName, String roomType, Date startDate, Date endDate,
                                       Float price, Float discountPercent) {
}
