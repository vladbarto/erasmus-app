package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.bareSubject.BareSubjectResponseDTO;
import ro.tucn.erasmusbackend.model.BareSubjectEntity;

import java.util.List;

@Mapper
public interface BareSubjectMapper {
//    @Mapping(target="null")
    BareSubjectResponseDTO bareSubjectEntityToBareSubjectResponseDTO(BareSubjectEntity bareSubjectEntity);

    List<BareSubjectResponseDTO> bareSubjectEntityListToBareSubjectResponseDTOList(List<BareSubjectEntity> BareSubjectEntityList);

    BareSubjectEntity bareSubjectRequestDTOToBareSubjectEntity(BareSubjectRequestDTO bareSubjectRequestDTO);
}
