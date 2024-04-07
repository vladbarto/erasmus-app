package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;
import ro.tucn.erasmusbackend.model.RepresentativeEntity;

import java.util.List;

@Mapper
public interface RepresentativeMapper {
    RepresentativeResponseDTO representativeEntityToRepresentativeResponseDTO(RepresentativeEntity representativeEntity);

    List<RepresentativeResponseDTO> representativeEntityListToRepresentativeResponseDTOList(List<RepresentativeEntity> representativeEntityList);

    RepresentativeEntity representativeRequestDTOToRepresentativeEntity(RepresentativeRequestDTO representativeRequestDTO);
}
