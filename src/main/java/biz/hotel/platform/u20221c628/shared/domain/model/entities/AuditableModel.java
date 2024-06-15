package biz.hotel.platform.u20221c628.shared.domain.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass // JPA annotation that allows the class to be inherited by other entities
public class AuditableModel {
    @Getter
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createdAt;

    @Getter
    @CreatedDate
    @Column(nullable = false)
    private Date updatedAt;
}
