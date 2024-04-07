package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;
import ro.tucn.erasmusbackend.dto.student.StudentResponseDTO;
import ro.tucn.erasmusbackend.model.StudentEntity;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentResponseDTO studentEntityToStudentResponseDTO(StudentEntity studentEntity);

    List<StudentResponseDTO> studentEntityListToStudentResponseDTOList(List<StudentEntity> studentEntityList);

    StudentEntity studentRequestDTOToStudentEntity(StudentRequestDTO studentRequestDTO);
}
