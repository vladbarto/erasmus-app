package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
