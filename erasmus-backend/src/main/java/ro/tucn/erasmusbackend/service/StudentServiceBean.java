package ro.tucn.erasmusbackend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;
import ro.tucn.erasmusbackend.dto.student.StudentResponseDTO;
import ro.tucn.erasmusbackend.mapper.StudentMapper;
import ro.tucn.erasmusbackend.model.StudentEntity;
import ro.tucn.erasmusbackend.repository.StudentRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class StudentServiceBean implements StudentService {
    
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final String applicationName;

    @Override
    public List<StudentResponseDTO> findAll() {
        log.info("Getting all chefs for application {}", applicationName);

        List<StudentEntity> studentEntityList = studentRepository.findAll();

        return studentMapper.studentEntityListToStudentResponseDTOList(studentEntityList);
    }

    @Override
    @Transactional
    public StudentResponseDTO save(StudentRequestDTO studentRequestDTO) {
        StudentEntity studentToBeAdded = studentMapper.studentRequestDTOToStudentEntity(studentRequestDTO);
        StudentEntity studentAdded = studentRepository.save(studentToBeAdded);

        return studentMapper.studentEntityToStudentResponseDTO(studentAdded);
    }
    
}
