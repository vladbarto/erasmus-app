package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;
import ro.tucn.erasmusbackend.model.RepresentativeEntity;

import java.util.List;

/**
 * Mapper that handles conversion of representatives between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface RepresentativeMapper {

    /**
     * Method that receives data (one object) from DB and prepares it as a response
     * @param representativeEntity - response from DB
     * @return data in form of a response dto object
     */
    RepresentativeResponseDTO representativeEntityToRepresentativeResponseDTO(RepresentativeEntity representativeEntity);

    /**
     * Method that receives data (more objects) from DB and prepares it as a response
     * @param representativeEntityList - a list of (all) objects from DB
     * @return list of (all) data in form of a response dto
     */
    List<RepresentativeResponseDTO> representativeEntityListToRepresentativeResponseDTOList(List<RepresentativeEntity> representativeEntityList);

    /**
     * Method that gets data from user, and it is asked to update the DB
     * @param representativeRequestDTO - an object from user (client) to be stored in DB
     * @return the object suitable for DB update
     */
    RepresentativeEntity representativeRequestDTOToRepresentativeEntity(RepresentativeRequestDTO representativeRequestDTO);
}
