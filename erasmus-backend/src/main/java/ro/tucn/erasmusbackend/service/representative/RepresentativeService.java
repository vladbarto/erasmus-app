package ro.tucn.erasmusbackend.service.representative;

import ro.tucn.erasmusbackend.dto.representative.RepresentativeRequestDTO;
import ro.tucn.erasmusbackend.dto.representative.RepresentativeResponseDTO;

import java.util.List;
import java.util.UUID;

/**
 * Service class that defines Representative CRUD operations
 * This includes:
 * - Finding all representatives
 * - Saving a representative
 */
public interface RepresentativeService {
    /**
     * Method that returns all representatives
     * @return list of all representatives
     */
    List<RepresentativeResponseDTO> findAll();

    /**
     * Method that saves a representative
     * @param representativeRequestDTO - object that stores the attributes by which a representative should be saved
     * @return object of type ResponseDTO containing all attributes of a Representative saved in DB
     */
    RepresentativeResponseDTO save(RepresentativeRequestDTO representativeRequestDTO);

    /**
     * Method that returns details of a representative
     * @param personId desired representative id
     * @return details of desired representative
     */
    RepresentativeResponseDTO findById(UUID personId);

    /*RepresentativeResponseDTO update(RepresentativeRequestDTO representativeRequestDTO, UUID representativeId);

    RepresentativeResponseDTO deleteById(UUID representativeId);*/
}
