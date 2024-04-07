package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.PersonEntity;

public interface PersonRepository extends JpaRepository<PersonEntity, String> {
}
