package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.faculty.FacultyRequestDTO;
import ro.tucn.erasmusbackend.dto.faculty.FacultyResponseDTO;
import ro.tucn.erasmusbackend.service.FacultyService;

import java.util.List;

/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/faculty/v1")
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    /**
     * Method that returns to client all found faculties
     * @return list of all faculties and an http status
     */
    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<FacultyResponseDTO>> findAll() {
        return new ResponseEntity<>(
                facultyService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param facultyRequestDTO - data of faculty to be saved
     * @return the data to be saved and an http status
     */
    @PostMapping("/save-one")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FacultyResponseDTO> saveFaculty(
            @RequestBody FacultyRequestDTO facultyRequestDTO
    ) {
        return new ResponseEntity<>(
                facultyService.save(facultyRequestDTO),
                HttpStatus.CREATED
        );
    }
}