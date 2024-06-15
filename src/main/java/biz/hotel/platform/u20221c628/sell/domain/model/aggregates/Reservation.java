package biz.hotel.platform.u20221c628.sell.domain.model.aggregates;

import biz.hotel.platform.u20221c628.sell.domain.model.commands.CreateReservationCommand;
import biz.hotel.platform.u20221c628.sell.domain.model.valueobjects.Guest;
import biz.hotel.platform.u20221c628.sell.domain.model.valueobjects.Room;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Getter
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotNull
    @Column(nullable = false)
    @Embedded
    private Guest guest;

    @NotNull
    @Column(nullable = false)
    @AttributeOverrides({
            @AttributeOverride(name="id", column=@Column(name="room_id")),
            @AttributeOverride(name="name", column=@Column(name="room_name")),
            @AttributeOverride(name="type", column=@Column(name="room_type"))
    })
    @Embedded
    private Room room;

    @NotNull
    @Column(nullable = false)
    private Date startDate;

    private Date endDate;

    @NotNull
    @Column(nullable = false)
    private Float price;

    @NotNull
    @Column(nullable = false)
    private Float discountPercent;


    public Reservation(CreateReservationCommand command){
        this.guest = new Guest(command.guestDni(), command.guestName(), command.guestEmail());
        this.room = new Room(command.roomId(), command.roomName(), command.roomType());
        this.startDate =  command.startDate();
        this.endDate = command.endDate() != null ? command.endDate() : null; // Si endDate es null, se asigna null
        this.price = command.price();
        this.discountPercent = command.discountPercent();
    }
}
