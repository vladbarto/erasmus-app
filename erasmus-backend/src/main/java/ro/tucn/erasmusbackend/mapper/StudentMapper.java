package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;
import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;
import ro.tucn.erasmusbackend.dto.student.StudentResponseDTO;
import ro.tucn.erasmusbackend.model.RepresentativeEntity;
import ro.tucn.erasmusbackend.model.StudentEntity;

import java.util.List;

/**
 * Mapper that handles conversion of students between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface StudentMapper extends GenericMapper<StudentEntity, StudentRequestDTO, StudentResponseDTO> {
}
