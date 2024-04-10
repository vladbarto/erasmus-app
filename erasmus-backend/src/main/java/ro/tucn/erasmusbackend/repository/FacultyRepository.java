package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.FacultyEntity;

import java.util.UUID;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for faculty
 */
public interface FacultyRepository extends JpaRepository<FacultyEntity, UUID> {
}
