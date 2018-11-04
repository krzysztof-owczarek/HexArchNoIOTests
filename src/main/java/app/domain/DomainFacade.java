package app.domain;

import app.exception.AppException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DomainFacade {

    private final DomainRepository domainRepository;

    DomainEntity save(DomainEntity domainEntity) {
        return domainRepository.save(domainEntity);
    }

    public List<DomainEntity> findAll() {
        return domainRepository.findAll();
    }

    public List<DomainEntity> findAllByMessage(String message) {
        return domainRepository.findAllByMessage(message);
    }

    public DomainEntity findById(long id) {
        return domainRepository.findById(id)
                .orElseThrow(() -> new AppException("Entity with id: " + id + " was not found..."));
    }
}
