package ro.tucn.erasmusbackend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.student.StudentRequestDTO;
import ro.tucn.erasmusbackend.dto.student.StudentResponseDTO;
import ro.tucn.erasmusbackend.exception.ExceptionBody;
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
     * @return list of all students and a http status
     */
    @GetMapping("/all")
    @Operation(summary = "Gets all students", description = "at least one student must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Student not found",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionBody.class))})
    })
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
     * @return the data to be saved and  a http status
     */
    @PostMapping("/save-one")
    @Operation(summary = "Save one student")
    @ApiResponse(responseCode = "201", description = "Student successfully created",
            content = {@Content(mediaType = "application/json", schema = @Schema(implementation = StudentResponseDTO.class))})
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
