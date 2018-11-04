package app.domain;

import org.springframework.context.annotation.Configuration;

@Configuration
class DomainConfiguration {

    public DomainFacade domainFacade(DomainRepository domainRepository) {
        return new DomainFacade(domainRepository);
    }
}
