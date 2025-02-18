package ro.tucn.erasmusbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.tucn.erasmusbackend.model.AnnouncementEntity;

import java.util.UUID;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for announcement
 */
@Repository
public interface AnnouncementRepository extends JpaRepository<AnnouncementEntity, UUID> {

}
