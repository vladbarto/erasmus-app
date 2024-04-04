package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tucn.erasmusbackend.model.ChefEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface ChefRepository extends JpaRepository<ChefEntity, UUID> {

    List<ChefEntity> findAllByRatingGreaterThan(double rating);
}
