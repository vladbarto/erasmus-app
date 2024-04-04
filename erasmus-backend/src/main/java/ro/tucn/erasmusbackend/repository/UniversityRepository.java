package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.UniversityEntity;

public interface UniversityRepository extends JpaRepository<UniversityEntity, String> {
}
