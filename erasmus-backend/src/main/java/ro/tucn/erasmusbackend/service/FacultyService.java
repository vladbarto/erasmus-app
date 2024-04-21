package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Service class that defines Faculty CRUD operations
 * This includes:
 * - Finding all faculties
 * - Saving a faculty
 */
public interface FacultyService {

    /**
     * Method that returns all faculties
     * @return list of all faculties
     */
    List<FacultyResponseDTO> findAll();

    /**
     * Method that returns details of a faculty
     * @param facultyId desired faculty id
     * @return details of desired faculty
     */
    FacultyResponseDTO findById(UUID facultyId);

    /**
     * Method that saves a faculty
     * @param facultyRequestDTO - object that stores the attributes by which a faculty should be saved
     * @return object of type ResponseDTO containing all attributes of a Faculty saved in DB
     */
    FacultyResponseDTO save(FacultyRequestDTO facultyRequestDTO);
}
