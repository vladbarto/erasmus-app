package ro.tucn.erasmusbackend.repository;

import ro.tucn.erasmusbackend.model.BareSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository that supports pre-implemented CRUD operations; adapted for bare subject
 */
@Repository
public interface BareSubjectRepository extends JpaRepository<BareSubjectEntity, Integer> {
    //List<BareSubjectEntity> findAllByRatingGreaterThan();
    //BareSubjectEntity save();
}
