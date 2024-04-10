package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;
import ro.tucn.erasmusbackend.model.BareSubjectEntity;

import java.util.List;

/**
 * Mapper that handles conversion of bare Subjects between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface BareSubjectMapper {

    /**
     * Method that receives data (one object) from DB and prepares it as a response
     * @param bareSubjectEntity - response from DB
     * @return data in form of a response dto object
     */
    BareSubjectResponseDTO bareSubjectEntityToBareSubjectResponseDTO(BareSubjectEntity bareSubjectEntity);

    /**
     * Method that receives data (more objects) from DB and prepares it as a response
     * @param bareSubjectEntityList - a list of (all) objects from DB
     * @return list of (all) data in form of a response dto
     */
    List<BareSubjectResponseDTO> bareSubjectEntityListToBareSubjectResponseDTOList(List<BareSubjectEntity> bareSubjectEntityList);

    /**
     * Method that gets data from user, and it is asked to update the DB
     * @param bareSubjectRequestDTO - an object from user (client) to be stored in DB
     * @return the object suitable for DB update
     */
    BareSubjectEntity bareSubjectRequestDTOToBareSubjectEntity(BareSubjectRequestDTO bareSubjectRequestDTO);
}
