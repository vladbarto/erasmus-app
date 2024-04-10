package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;

import java.util.List;
/**
 * Service class that defines UniqueSubject CRUD operations
 * This includes:
 * - Finding all uniqueSubjects
 * - Saving an uniqueSubject
 */
public interface UniqueSubjectService {

    /**
     * Method that returns all uniqueSubjects
     * @return list of all uniqueSubjects
     */
    List<UniqueSubjectResponseDTO> findAll();

    /**
     * Method that saves an uniqueSubject
     * @param uniqueSubjectRequestDTO - object that stores the attributes by which a unique subject should be saved
     * @return object of type ResponseDTO containing all attributes of an UniqueSubject saved in DB
     */
    UniqueSubjectResponseDTO save(UniqueSubjectRequestDTO uniqueSubjectRequestDTO);
}
