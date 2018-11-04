package app.domain;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.Repository;

interface DomainRepository extends Repository<DomainEntity, Long> {

    Optional<DomainEntity> findById(long id);

    List<DomainEntity> findAllByMessage(String message);

    List<DomainEntity> findAll();

    DomainEntity save(DomainEntity domainEntity);
}
