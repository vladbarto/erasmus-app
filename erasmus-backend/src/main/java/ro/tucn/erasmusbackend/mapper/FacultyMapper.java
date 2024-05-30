package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;
import ro.tucn.erasmusbackend.model.FacultyEntity;

/**
 * Mapper that handles conversion of faculties between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface FacultyMapper extends GenericMapper<FacultyEntity, FacultyRequestDTO, FacultyResponseDTO> {
}
