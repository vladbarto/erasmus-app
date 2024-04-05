package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;
import ro.tucn.erasmusbackend.model.UniqueSubjectEntity;

import java.util.List;

@Mapper
public interface UniqueSubjectMapper {
    UniqueSubjectResponseDTO uniqueSubjectEntityToUniqueSubjectResponseDTO(UniqueSubjectEntity uniqueSubjectEntity);

    List<UniqueSubjectResponseDTO> uniqueSubjectEntityListToUniqueSubjectResponseDTOList(List<UniqueSubjectEntity> UniqueSubjectEntityList);

    UniqueSubjectEntity uniqueSubjectRequestDTOToUniqueSubjectEntity(UniqueSubjectRequestDTO uniqueSubjectRequestDTO);
}
