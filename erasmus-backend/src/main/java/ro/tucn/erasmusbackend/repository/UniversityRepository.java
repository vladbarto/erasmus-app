package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.UniversityEntity;

import java.util.Optional;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for university
 */
public interface UniversityRepository extends JpaRepository<UniversityEntity, String> {
//    Optional<UniversityEntity> findByCode(String universityCode);
}
