package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;

import java.util.List;

public interface PersonService {
    List<PersonResponseDTO> findAll();

    PersonResponseDTO save(PersonRequestDTO personRequestDTO);
}
