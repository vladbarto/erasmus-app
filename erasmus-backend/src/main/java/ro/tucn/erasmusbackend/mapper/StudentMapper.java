package ro.tucn.erasmusbackend.mapper;

import org.mapstruct.Mapper;
import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;
import ro.tucn.erasmusbackend.dto.student.StudentResponseDTO;
import ro.tucn.erasmusbackend.model.StudentEntity;

import java.util.List;

/**
 * Mapper that handles conversion of students between database (as entity object) and Request DTO and Response DTO respectively.
 */
@Mapper
public interface StudentMapper {

    /**
     * Method that receives data (one object) from DB and prepares it as a response
     * @param studentEntity - response from DB
     * @return data in form of a response dto object
     */
    StudentResponseDTO studentEntityToStudentResponseDTO(StudentEntity studentEntity);

    /**
     * Method that receives data (more objects) from DB and prepares it as a response
     * @param studentEntityList - a list of (all) objects from DB
     * @return list of (all) data in form of a response dto
     */
    List<StudentResponseDTO> studentEntityListToStudentResponseDTOList(List<StudentEntity> studentEntityList);

    /**
     * Method that gets data from user, and it is asked to update the DB
     * @param studentRequestDTO - an object from user (client) to be stored in DB
     * @return the object suitable for DB update
     */
    StudentEntity studentRequestDTOToStudentEntity(StudentRequestDTO studentRequestDTO);
}
