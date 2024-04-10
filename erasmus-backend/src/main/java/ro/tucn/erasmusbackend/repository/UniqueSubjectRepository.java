package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.UniqueSubjectEntity;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for unique subject
 */
public interface UniqueSubjectRepository extends JpaRepository<UniqueSubjectEntity, String> {
}
