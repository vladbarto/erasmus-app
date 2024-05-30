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
public interface RepresentativeMapper extends GenericMapper<RepresentativeEntity, RepresentativeRequestDTO, RepresentativeResponseDTO> {
}
