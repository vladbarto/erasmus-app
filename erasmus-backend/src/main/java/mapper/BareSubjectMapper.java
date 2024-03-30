package mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import dto.bareSubject.BareSubjectRequestDTO;
import dto.bareSubject.BareSubjectResponseDTO;
import model.BareSubjectEntity;
import java.util.List;

@Mapper
public interface BareSubjectMapper {
//    @Mapping(target="null")
    BareSubjectResponseDTO bareSubjectEntityToBareSubjectResponseDTO(BareSubjectEntity bareSubjectEntity);

    List<BareSubjectResponseDTO> bareSubjectEntityListToBareSubjectResponseDTOList(List<BareSubjectEntity> BareSubjectEntityList);

    BareSubjectEntity bareSubjectRequestDTOToBareSubjectEntity(BareSubjectRequestDTO bareSubjectRequestDTO);
}
