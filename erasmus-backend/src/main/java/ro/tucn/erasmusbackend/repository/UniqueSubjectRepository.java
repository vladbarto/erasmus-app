package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.UniqueSubjectEntity;

public interface UniqueSubjectRepository extends JpaRepository<UniqueSubjectEntity, String> {
}
