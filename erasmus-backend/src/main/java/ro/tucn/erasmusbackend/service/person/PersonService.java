package ro.tucn.erasmusbackend.service.person;

import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;
import ro.tucn.erasmusbackend.dto.person.PersonRequestDTO;
import ro.tucn.erasmusbackend.dto.person.PersonResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Service class that defines Person CRUD operations
 * This includes:
 * - Finding all persons
 * - Saving a person
 */
public interface PersonService {
    /**
     * Method that returns all persons
     * @return list of all persons
     */
    List<PersonResponseDTO> findAll();
   
    /**
     * Method that saves a person
     * @param personRequestDTO - object that stores the attributes by which a person should be saved
     * @return object of type ResponseDTO containing all attributes of a Person saved in DB
     */
    PersonResponseDTO save(PersonRequestDTO personRequestDTO);

    /**
     * Method that returns details of a person
     * @param personId desired person id
     * @return details of desired person
     */
    PersonResponseDTO findById(UUID personId);

    PersonResponseDTO update(PersonRequestDTO personRequestDTO, UUID personId);

    PersonResponseDTO deleteById(UUID personId);
}
