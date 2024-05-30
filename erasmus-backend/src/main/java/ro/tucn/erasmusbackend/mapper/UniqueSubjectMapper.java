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
public interface UniqueSubjectMapper extends GenericMapper<UniqueSubjectEntity, UniqueSubjectRequestDTO, UniqueSubjectResponseDTO> {
}
