package app

import app.domain.DomainEntity
import app.domain.DomainFacade
import app.domain.InMemoryDomainRepository
import spock.lang.Specification

class AppSpec extends Specification {

    DomainFacade domainFacade = new DomainFacade(new InMemoryDomainRepository())
    AppEndpoint appEndpoint = new AppEndpoint(domainFacade)

    def 'Find all domain entities'() {
        given: 'existing entities'
        domainFacade.save(DomainEntity.builder().id(1L).message("msg1").build())
        domainFacade.save(DomainEntity.builder().id(2L).message("msg2").build())

        when: 'call findAll()'
        def all = appEndpoint.getAllEntities().getBody()

        then: 'found 2 entities'
        all.size() == 2
    }

    def 'Find all domain entities with message'() {
        given: 'existing entities'
        domainFacade.save(DomainEntity.builder().id(1L).message("msg1").build())
        domainFacade.save(DomainEntity.builder().id(2L).message("msg1").build())
        domainFacade.save(DomainEntity.builder().id(3L).message("msg3").build())

        when: 'call findAllByMessage()'
        def allByMessage = appEndpoint.getAllEntitiesWithMessage("msg1").getBody()

        then: 'found 2 entities with message'
        allByMessage.size() == 2
    }

    def 'Find domain entity by id'() {
        given: 'existing entities'
        def theEntity = domainFacade.save(DomainEntity.builder().id(1L).message("msg1").build())
        domainFacade.save(DomainEntity.builder().id(2L).message("msg2").build())
        domainFacade.save(DomainEntity.builder().id(3L).message("msg3").build())

        when: 'call findById()'
        def entity = appEndpoint.getEntityById(1L).getBody()

        then: 'found entity with id'
        entity == theEntity
    }
}
