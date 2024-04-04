package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.FacultyEntity;

public interface FacultyRepository extends JpaRepository<FacultyEntity, Integer> {
}
