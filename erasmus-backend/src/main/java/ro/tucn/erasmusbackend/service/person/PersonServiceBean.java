package ro.tucn.erasmusbackend.service.person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.mapper.PersonMapper;
import ro.tucn.erasmusbackend.model.PersonEntity;
import ro.tucn.erasmusbackend.repository.PersonRepository;

import java.util.List;

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
}
