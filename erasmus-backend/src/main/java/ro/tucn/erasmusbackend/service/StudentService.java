package ro.tucn.erasmusbackend.service;

import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;
import ro.tucn.erasmusbackend.dto.student.StudentResponseDTO;

import java.util.List;
/**
 * Service class that defines Student CRUD operations
 * This includes:
 * - Finding all students
 * - Saving a student
 */
public interface StudentService {
    /**
     * Method that returns all students
     * @return list of all students
     */
    List<StudentResponseDTO> findAll();
    
    /**
     * Method that saves a student
     * @param studentRequestDTO - object that stores the attributes by which a student should be saved
     * @return object of type ResponseDTO containing all attributes of a Student saved in DB
     */
    StudentResponseDTO save(StudentRequestDTO studentRequestDTO);
}
