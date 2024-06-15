package biz.hotel.platform.u20221c628.sell.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Room(Integer id, String name, String type) {
}
