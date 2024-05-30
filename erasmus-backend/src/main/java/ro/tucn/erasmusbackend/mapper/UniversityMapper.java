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
public interface UniversityMapper extends GenericMapper<UniversityEntity, UniversityRequestDTO, UniversityResponseDTO> {
}
