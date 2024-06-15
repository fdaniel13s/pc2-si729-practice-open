package biz.hotel.platform.u20221c628.sell.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record Guest(String dni, String name, String email) {
}