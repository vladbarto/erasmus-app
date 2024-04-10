package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.university.UniversityRequestDTO;
import ro.tucn.erasmusbackend.dto.university.UniversityResponseDTO;
import ro.tucn.erasmusbackend.service.UniversityService;

import java.util.List;
/**
 * Manages interaction between client and server
 */
@RestController
@RequestMapping("/university/v1")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService universityService;

    /**
     * Method that returns to client all found universities
     * @return list of all universities and an http status
     */
    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<List<UniversityResponseDTO>> findAll() {
        return new ResponseEntity<>(
                universityService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Method that sends to the server a save request
     * @param universityRequestDTO - data of university to be saved
     * @return the data to be saved and an http status
     */
    @PostMapping("/save-one")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UniversityResponseDTO> saveUniversity(
            @RequestBody UniversityRequestDTO universityRequestDTO
    ) {
        return new ResponseEntity<>(
                universityService.save(universityRequestDTO),
                HttpStatus.CREATED
        );
    }
}
