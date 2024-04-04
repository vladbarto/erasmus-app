package ro.tucn.erasmusbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tucn.erasmusbackend.dto.university.UniversityRequestDTO;
import ro.tucn.erasmusbackend.dto.university.UniversityResponseDTO;
import ro.tucn.erasmusbackend.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/university/v1")
@RequiredArgsConstructor
public class UniversityController {
    private final UniversityService universityService;
    @GetMapping("/all")
    public ResponseEntity<List<UniversityResponseDTO>> findAll() {
        return new ResponseEntity<>(
                universityService.findAll(),
                HttpStatus.OK
        );
    }

    @PostMapping("/save-one")
    public ResponseEntity<UniversityResponseDTO> saveUniversity(
            @RequestBody UniversityRequestDTO universityRequestDTO
    ) {
        return new ResponseEntity<>(
                universityService.save(universityRequestDTO),
                HttpStatus.CREATED
        );
    }
}
