package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.university.UniversityRequestDTO;
import ro.tucn.erasmusbackend.dto.university.UniversityResponseDTO;
import ro.tucn.erasmusbackend.model.UniversityEntity;

import java.util.List;

@Mapper
public interface UniversityMapper {
    UniversityResponseDTO universityEntityToUniversityResponseDTO(UniversityEntity universityEntity);

    List<UniversityResponseDTO> universityEntityListToUniversityResponseDTOList(List<UniversityEntity> universityEntityList);

    UniversityEntity universityRequestDTOToUniversityEntity(UniversityRequestDTO universityRequestDTO);
}
