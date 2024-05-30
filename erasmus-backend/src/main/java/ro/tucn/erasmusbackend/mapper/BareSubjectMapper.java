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
public interface BareSubjectMapper extends GenericMapper<BareSubjectEntity, BareSubjectRequestDTO, BareSubjectResponseDTO>{
}
