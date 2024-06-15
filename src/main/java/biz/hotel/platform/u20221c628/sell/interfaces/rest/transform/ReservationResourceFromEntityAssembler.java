package biz.hotel.platform.u20221c628.sell.interfaces.rest.transform;

import biz.hotel.platform.u20221c628.sell.domain.model.aggregates.Reservation;
import biz.hotel.platform.u20221c628.sell.interfaces.rest.resources.ReservationResource;

public class ReservationResourceFromEntityAssembler {
    public static ReservationResource toResourceFromEntity(Reservation entity) {
        return new ReservationResource(
                entity.getId(),
                entity.getGuest().dni(),
                entity.getGuest().name(),
                entity.getGuest().email(),
                entity.getRoom().id(),
                entity.getRoom().name(),
                entity.getRoom().type(),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getPrice(),
                entity.getDiscountPercent()
        );
    }
}
