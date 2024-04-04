package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;

import java.util.List;

public interface FacultyService {
    List<FacultyResponseDTO> findAll();

    FacultyResponseDTO save(FacultyRequestDTO facultyRequestDTO);
}
