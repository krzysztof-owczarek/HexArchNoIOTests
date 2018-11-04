package app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
@Builder
class DomainEntity {

    @Id
    @GeneratedValue
    private long id;

    private String message;
}
