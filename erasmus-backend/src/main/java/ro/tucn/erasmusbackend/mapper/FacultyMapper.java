package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;
import ro.tucn.erasmusbackend.model.FacultyEntity;

import java.util.List;

/**
 * Mapper that handles conversion of faculties between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface FacultyMapper {
    /**
     * Method that receives data (one object) from DB and prepares it as a response
     * @param facultyEntity - response from DB
     * @return data in form of a response dto object
     */
    FacultyResponseDTO facultyEntityToFacultyResponseDTO(FacultyEntity facultyEntity);

    /**
     * Method that receives data (more objects) from DB and prepares it as a response
     * @param facultyEntityList - a list of (all) objects from DB
     * @return list of (all) data in form of a response dto
     */
    List<FacultyResponseDTO> facultyEntityListToFacultyResponseDTOList(List<FacultyEntity> facultyEntityList);

    /**
     * Method that gets data from user, and it is asked to update the DB
     * @param facultyRequestDTO - an object from user (client) to be stored in DB
     * @return the object suitable for DB update
     */
    FacultyEntity facultyRequestDTOToFacultyEntity(FacultyRequestDTO facultyRequestDTO);
}
