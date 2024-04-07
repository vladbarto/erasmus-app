package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.model.PersonEntity;

import java.util.List;

@Mapper
public interface PersonMapper {
    PersonResponseDTO personEntityToPersonResponseDTO(PersonEntity personEntity);

    List<PersonResponseDTO> personEntityListToPersonResponseDTOList(List<PersonEntity> personEntityList);

    PersonEntity personRequestDTOToPersonEntity(PersonRequestDTO personRequestDTO);
}
