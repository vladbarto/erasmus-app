package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;
import ro.tucn.erasmusbackend.dto.student.StudentResponseDTO;

import java.util.List;

public interface StudentService {
    List<StudentResponseDTO> findAll();

    StudentResponseDTO save(StudentRequestDTO studentRequestDTO);
}
