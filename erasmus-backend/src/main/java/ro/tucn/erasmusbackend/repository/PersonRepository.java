package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.PersonEntity;

import java.util.UUID;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for person
 */
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
}
