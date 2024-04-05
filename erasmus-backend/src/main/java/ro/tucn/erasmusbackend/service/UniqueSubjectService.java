package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectRequestDTO;
import ro.tucn.erasmusbackend.dto.uniqueSubject.UniqueSubjectResponseDTO;

import java.util.List;

public interface UniqueSubjectService {
    List<UniqueSubjectResponseDTO> findAll();
    UniqueSubjectResponseDTO save(UniqueSubjectRequestDTO uniqueSubjectRequestDTO);
}
