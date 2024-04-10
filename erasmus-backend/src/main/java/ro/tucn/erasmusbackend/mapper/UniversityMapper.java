package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.university.UniversityRequestDTO;
import ro.tucn.erasmusbackend.dto.university.UniversityResponseDTO;
import ro.tucn.erasmusbackend.model.UniversityEntity;

import java.util.List;

/**
 * Mapper that handles conversion of universities between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface UniversityMapper {

    /**
     * Method that receives data (one object) from DB and prepares it as a response
     * @param universityEntity - response from DB
     * @return data in form of a response dto object
     */
    UniversityResponseDTO universityEntityToUniversityResponseDTO(UniversityEntity universityEntity);

    /**
     * Method that receives data (more objects) from DB and prepares it as a response
     * @param universityEntityList - a list of (all) objects from DB
     * @return list of (all) data in form of a response dto
     */
    List<UniversityResponseDTO> universityEntityListToUniversityResponseDTOList(List<UniversityEntity> universityEntityList);

    /**
     * Method that gets data from user, and it is asked to update the DB
     * @param universityRequestDTO - an object from user (client) to be stored in DB
     * @return the object suitable for DB update
     */
    UniversityEntity universityRequestDTOToUniversityEntity(UniversityRequestDTO universityRequestDTO);
}
