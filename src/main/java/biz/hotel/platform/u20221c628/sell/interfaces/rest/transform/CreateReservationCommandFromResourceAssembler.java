package biz.hotel.platform.u20221c628.sell.interfaces.rest.transform;

import biz.hotel.platform.u20221c628.sell.domain.model.commands.CreateReservationCommand;
import biz.hotel.platform.u20221c628.sell.interfaces.rest.resources.CreateReservationResource;

public class CreateReservationCommandFromResourceAssembler {
    public static CreateReservationCommand toCommandFromResource(CreateReservationResource resource) {
        return new CreateReservationCommand(
                resource.guestDni(),
                resource.guestName(),
                resource.guestEmail(),
                resource.roomId(),
                resource.roomName(),
                resource.roomType(),
                resource.startDate(),
                resource.endDate(),
                resource.price(),
                resource.discountPercent()
        );
    }
}
