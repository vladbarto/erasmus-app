package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.StudentEntity;

import java.util.UUID;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for student
 */
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
}
