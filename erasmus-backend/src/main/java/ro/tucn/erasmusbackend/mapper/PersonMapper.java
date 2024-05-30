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
public interface PersonMapper extends GenericMapper<PersonEntity, PersonRequestDTO, PersonResponseDTO> {
}
