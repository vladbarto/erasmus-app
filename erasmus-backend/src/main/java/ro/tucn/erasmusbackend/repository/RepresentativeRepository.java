package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.tucn.erasmusbackend.model.RepresentativeEntity;

import java.util.UUID;

public interface RepresentativeRepository extends JpaRepository<RepresentativeEntity, String> {
}
