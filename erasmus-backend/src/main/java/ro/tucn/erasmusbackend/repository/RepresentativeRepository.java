package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.RepresentativeEntity;

import java.util.UUID;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for representative
 */
public interface RepresentativeRepository extends JpaRepository<RepresentativeEntity, UUID> {
}
