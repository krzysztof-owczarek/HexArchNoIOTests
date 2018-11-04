package app.domain;

import app.domain.DomainEntity;
import app.domain.DomainRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class InMemoryDomainRepository implements DomainRepository {

    private Map<Long, DomainEntity> map = new ConcurrentHashMap<>();

    @Override
    public Optional<DomainEntity> findById(long id) {
        return Optional.ofNullable(map.get(id));
    }

    @Override
    public List<DomainEntity> findAllByMessage(String message) {
        return map.entrySet().stream()
                .map(Map.Entry::getValue)
                .filter(x -> message.equals(x.getMessage()))
                .collect(Collectors.toList());
    }

    @Override
    public List<DomainEntity> findAll() {
        return map.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    @Override
    public DomainEntity save(DomainEntity domainEntity) {

        if (domainEntity == null) {
            throw new NullPointerException();
        }

        map.put(domainEntity.getId(), domainEntity);

        return map.get(domainEntity.getId());
    }
}
