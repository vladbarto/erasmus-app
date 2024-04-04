package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.university.UniversityRequestDTO;
import ro.tucn.erasmusbackend.dto.university.UniversityResponseDTO;
import java.util.List;

public interface UniversityService {

    List<UniversityResponseDTO> findAll();
    UniversityResponseDTO save(UniversityRequestDTO universityRequestDTO);
}