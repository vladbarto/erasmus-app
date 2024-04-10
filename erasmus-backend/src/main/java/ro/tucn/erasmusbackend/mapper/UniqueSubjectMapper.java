package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;
import ro.tucn.erasmusbackend.model.UniqueSubjectEntity;

import java.util.List;

/**
 * Mapper that handles conversion of unique subjects between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface UniqueSubjectMapper {
    /**
     * Method that receives data (one object) from DB and prepares it as a response
     * @param uniqueSubjectEntity - response from DB
     * @return data in form of a response dto object
     */
    UniqueSubjectResponseDTO uniqueSubjectEntityToUniqueSubjectResponseDTO(UniqueSubjectEntity uniqueSubjectEntity);

    /**
     * Method that receives data (more objects) from DB and prepares it as a response
     * @param uniqueSubjectEntityList - a list of (all) objects from DB
     * @return list of (all) data in form of a response dto
     */
    List<UniqueSubjectResponseDTO> uniqueSubjectEntityListToUniqueSubjectResponseDTOList(List<UniqueSubjectEntity> uniqueSubjectEntityList);

    /**
     * Method that gets data from user, and it is asked to update the DB
     * @param uniqueSubjectRequestDTO - an object from user (client) to be stored in DB
     * @return the object suitable for DB update
     */
    UniqueSubjectEntity uniqueSubjectRequestDTOToUniqueSubjectEntity(UniqueSubjectRequestDTO uniqueSubjectRequestDTO);
}
