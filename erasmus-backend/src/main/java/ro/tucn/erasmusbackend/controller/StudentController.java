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

@RestController
@RequestMapping("/student/v1")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<StudentResponseDTO>> findAll() {
        return new ResponseEntity<>(
                studentService.findAll(),
                HttpStatus.OK
        );
    }

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
