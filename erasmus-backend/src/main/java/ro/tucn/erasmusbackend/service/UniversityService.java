package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.university.UniversityRequestDTO;
import ro.tucn.erasmusbackend.dto.university.UniversityResponseDTO;
import java.util.List;
/**
 * Service class that defines University CRUD operations
 * This includes:
 * - Finding all universities
 * - Saving a university
 */
public interface UniversityService {
    /**
     * Method that returns all universities
     * @return list of all universities
     */
    List<UniversityResponseDTO> findAll();

    /**
     * Method that saves a university
     * @param universityRequestDTO - object that stores the attributes by which a university should be saved
     * @return object of type ResponseDTO containing all attributes of a University saved in DB
     */
    UniversityResponseDTO save(UniversityRequestDTO universityRequestDTO);
}