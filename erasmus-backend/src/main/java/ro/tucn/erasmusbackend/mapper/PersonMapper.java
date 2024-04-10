package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.model.PersonEntity;

import java.util.List;

/**
 * Mapper that handles conversion of persons between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface PersonMapper {

    /**
     * Method that receives data (one object) from DB and prepares it as a response
     * @param personEntity - response from DB
     * @return data in form of a response dto object
     */
    PersonResponseDTO personEntityToPersonResponseDTO(PersonEntity personEntity);

    /**
     * Method that receives data (more objects) from DB and prepares it as a response
     * @param personEntityList - a list of (all) objects from DB
     * @return list of (all) data in form of a response dto
     */
    List<PersonResponseDTO> personEntityListToPersonResponseDTOList(List<PersonEntity> personEntityList);

    /**
     * Method that gets data from user, and it is asked to update the DB
     * @param personRequestDTO - an object from user (client) to be stored in DB
     * @return the object suitable for DB update
     */
    PersonEntity personRequestDTOToPersonEntity(PersonRequestDTO personRequestDTO);
}
