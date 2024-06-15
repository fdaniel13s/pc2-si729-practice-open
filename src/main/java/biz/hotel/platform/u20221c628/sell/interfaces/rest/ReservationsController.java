package biz.hotel.platform.u20221c628.sell.interfaces.rest;

import biz.hotel.platform.u20221c628.sell.domain.services.ReservationCommandService;
import biz.hotel.platform.u20221c628.sell.domain.services.ReservationQueryService;
import biz.hotel.platform.u20221c628.sell.interfaces.rest.resources.CreateReservationResource;
import biz.hotel.platform.u20221c628.sell.interfaces.rest.resources.ReservationResource;
import biz.hotel.platform.u20221c628.sell.interfaces.rest.transform.CreateReservationCommandFromResourceAssembler;
import biz.hotel.platform.u20221c628.sell.interfaces.rest.transform.ReservationResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api/v1/reservations", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Reservations", description = "Operations related to reservations")
public class ReservationsController {

    private final ReservationCommandService reservationCommandService;
    private final ReservationQueryService reservationQueryService;

    public ReservationsController(ReservationCommandService reservationCommandService, ReservationQueryService reservationQueryService) {
        this.reservationCommandService = reservationCommandService;
        this.reservationQueryService = reservationQueryService;
    }

    @PostMapping
    public ResponseEntity<ReservationResource> createReservation(@RequestBody CreateReservationResource resource) {
        var reservationCommand = CreateReservationCommandFromResourceAssembler.toCommandFromResource(resource);
        var reservation = reservationCommandService.handle(reservationCommand);
        var reservationResource = ReservationResourceFromEntityAssembler.toResourceFromEntity(reservation.get());
        return new ResponseEntity<>(reservationResource, HttpStatus.CREATED);
    }

}
