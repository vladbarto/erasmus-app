package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.RepresentativeEntity;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for representative
 */
public interface RepresentativeRepository extends JpaRepository<RepresentativeEntity, String> {
}
