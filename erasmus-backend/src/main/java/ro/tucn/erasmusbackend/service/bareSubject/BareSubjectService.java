package ro.tucn.erasmusbackend.service.bareSubject;

import org.springframework.stereotype.Service;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Service class that defines Bare Subject CRUD operations
 * This includes:
 * - Finding all bare subjects
 * - Saving a bare subject
 */
@Service
public interface BareSubjectService {

    /**
     * Method that returns all bareSubjects
     * @return list of all bareSubjects
     */
    List<BareSubjectResponseDTO> findAll();

    /**
     * Method that saves an bareSubject
     * @param bareSubjectRequestDTO - object that stores the attributes by which an bareSubject should be saved
     * @return object of type ResponseDTO containing all attributes of an BareSubject saved in DB
     */
    BareSubjectResponseDTO save(BareSubjectRequestDTO bareSubjectRequestDTO);

    /**
     * Method that returns details of a bareSubject
     * @param bareSubjectId desired bareSubject id
     * @return details of desired bareSubject
     */
    BareSubjectResponseDTO findById(UUID bareSubjectId);

    BareSubjectResponseDTO update(BareSubjectRequestDTO bareSubjectRequestDTO, UUID bareSubjectId);

    BareSubjectResponseDTO deleteById(UUID bareSubjectId);
}
