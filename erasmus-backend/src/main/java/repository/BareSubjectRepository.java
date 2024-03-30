package repository;

import model.BareSubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BareSubjectRepository extends JpaRepository<BareSubjectEntity, Integer> {
    //List<BareSubjectEntity> findAllByRatingGreaterThan();
    BareSubjectEntity save();
}
