package app;

import app.domain.DomainFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/app")
class AppEndpoint {

    private final DomainFacade domainFacade;

    @GetMapping("/allEntities")
    ResponseEntity getAllEntities() {
        return ResponseEntity.ok(domainFacade.findAll());
    }

    @GetMapping("/entity/{id}")
    ResponseEntity getEntityById(@PathVariable("id") long id) {
        return ResponseEntity.ok(domainFacade.findById(id));
    }

    @GetMapping("/allEntitiesWithMessage")
    ResponseEntity getAllEntitiesWithMessage(@RequestBody String message) {
        return ResponseEntity.ok(domainFacade.findAllByMessage(message));
    }
}
