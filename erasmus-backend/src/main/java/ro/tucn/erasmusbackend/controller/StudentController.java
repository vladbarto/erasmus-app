package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;
import ro.tucn.erasmusbackend.dto.student.StudentResponseDTO;
import ro.tucn.erasmusbackend.service.StudentService;

import java.util.List;
/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/student/v1")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    /**
     * Method that returns to client all found students
     * @return list of all students and an http status
     */
    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<StudentResponseDTO>> findAll() {
        return new ResponseEntity<>(
                studentService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param studentRequestDTO - data of student to be saved
     * @return the data to be saved and an http status
     */
    @PostMapping("/save-one")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<StudentResponseDTO> saveStudent(
            @RequestBody StudentRequestDTO studentRequestDTO
    ) {
        return new ResponseEntity<>(
                studentService.save(studentRequestDTO),
                HttpStatus.CREATED
        );
    }
}
