package ro.tucn.erasmusbackend.service.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionCode;
import ro.tucn.erasmusbackend.exception.NotFoundException;
import ro.tucn.erasmusbackend.mapper.PersonMapper;
import ro.tucn.erasmusbackend.model.PersonEntity;
import ro.tucn.erasmusbackend.repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class PersonServiceBean implements PersonService{
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;
    private final String applicationName;

    @Override
    public List<PersonResponseDTO> findAll() {
        log.info("Getting all chefs for application {}", applicationName);

        List<PersonEntity> personEntityList = personRepository.findAll();

        return personMapper.personEntityListToPersonResponseDTOList(personEntityList);
    }

    @Override
    @Transactional
    public PersonResponseDTO save(PersonRequestDTO personRequestDTO) {
        log.info("Posting a new person for application {}", applicationName);
        PersonEntity personToBeAdded = personMapper.personRequestDTOToPersonEntity(personRequestDTO);
        PersonEntity personAdded = personRepository.save(personToBeAdded);

        return personMapper.personEntityToPersonResponseDTO(personAdded);
    }

    @Override
    public PersonResponseDTO findById(UUID personId) {
        return personRepository.findById(personId)
                .map(personMapper::personEntityToPersonResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_PERSON_NOT_FOUND.getMessage(),
                        personId
                )));
    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personRequestDTO, UUID personId) {
        return personRepository.findById(personId)
                .map((personEntity)-> {
                    personEntity.setName(personRequestDTO.getName());
                    personEntity.setFacultyCode(personRequestDTO.getFacultyCode());
                    personEntity.setUniversityCode(personRequestDTO.getUniversityCode());
                    personEntity.setCity(personRequestDTO.getCity());
                    personEntity.setCNP(personRequestDTO.getCNP());
                    personEntity.setCountry(personRequestDTO.getCountry());
                    personEntity.setDateOfBirth(personRequestDTO.getDateOfBirth());
                    personEntity.setPhoneNumber(personRequestDTO.getPhoneNumber());

                    personRepository.save(personEntity);

                    return personEntity;
                })
                .map(personMapper::personEntityToPersonResponseDTO)
                .orElseThrow(() -> new NotFoundException(String.format(
                        ExceptionCode.ERR001_PERSON_NOT_FOUND.getMessage(),
                        personId
                )))
                ;
    }

    @Override
    public PersonResponseDTO deleteById(UUID personId) {
        List<UUID> ids = new ArrayList<>();
        ids.add(personId);

        personRepository.deleteAllByIdInBatch(ids);
        return null;
    }
}
